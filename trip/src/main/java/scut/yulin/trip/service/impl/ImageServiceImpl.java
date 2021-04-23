package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import scut.yulin.common.constant.CommonConstant;
import scut.yulin.common.utils.Inspections;
import scut.yulin.trip.dto.image.InsertImageDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.mbg.mapper.ImageDao;
import scut.yulin.trip.model.Image;
import scut.yulin.trip.model.ImageExample;
import scut.yulin.trip.service.ImageService;

import java.util.List;

/**
 * 图片service实现类
 *
 * @date 2021/04/19
 */
@Slf4j
@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    /**
     * @param insertImageDTO
     * @return 1:ok;  0:ko
     */
    @Override
    public int addNewImage(InsertImageDTO insertImageDTO) {
        String creatorUuid = insertImageDTO.getCreatorUuid();
        String scheduleUuid = insertImageDTO.getScheduleUuid();
        String scheduleTypeUuid = insertImageDTO.getScheduleTypeUuid();
        String url = insertImageDTO.getUrl();
        String name = Inspections.isNotBlank(insertImageDTO.getName()) ? insertImageDTO.getName() : "defaultImageName";
        String headImage = Inspections.isNotBlank(insertImageDTO.getHeadImage()) ? "1" : "0";

        //由于url过长，无法在数据库中建立(scheduleTypeUuid, scheduleUuid, creatorUuid, Url)的唯一索引
        //故在此进行判断，以防止同一个用户对某个行程刷同一个图片评论
        QueryImageDTO tempQueryImageDTO = new QueryImageDTO(null, scheduleUuid, scheduleTypeUuid, creatorUuid);
        List<Image> imageList = this.findImagesByCreatorUUIDAndScheduleUUID(tempQueryImageDTO);
        if (imageList.size() > 0) {
            for (Image image : imageList) {
                if (image.getUrl().equals(url)) {
                    return 0;
                }
            }
        }

        Assert.notBlank(creatorUuid);
        Assert.notBlank(scheduleUuid);
        Assert.notBlank(scheduleTypeUuid);
        Assert.notBlank(name);
        Assert.notBlank(url);
        Assert.notBlank(headImage);

        Image image = new Image(IdUtil.randomUUID(),
                scheduleUuid,
                scheduleTypeUuid,
                creatorUuid,
                name,
                url,
                headImage);
        return imageDao.insertSelective(image);
    }

    @Override
    public Image findImageByUuid(QueryImageDTO queryImageDTO) {
        ImageExample example = new ImageExample();
        String uuid = queryImageDTO.getUuid();
        example.createCriteria()
                .andUuidEqualTo(uuid)
                .andDeletedEqualTo(CommonConstant.NOT_DELETED);
        List<Image> images = imageDao.selectByExample(example);
        if (images.size() > 0) {
            return images.get(0);
        }
        return null;
    }

    @Override
    public List<Image> getImageListByScheduleUUID(QueryImageDTO queryImageDTO) {
        String scheduleUuid = queryImageDTO.getScheduleUuid();
        if (scheduleUuid == null) {
            return null;
        }
        ImageExample example = new ImageExample();
        example.setLimit(queryImageDTO.getPageSize());
        example.setOffset(queryImageDTO.getOffset());
        example.createCriteria()
                .andScheduleUuidEqualTo(scheduleUuid)
                .andDeletedEqualTo(CommonConstant.NOT_DELETED);
        return imageDao.selectByExample(example);
    }

    @Override
    public List<Image> findImagesByScheduleTypeUUID(QueryImageDTO queryImageDTO) {
        ImageExample example = new ImageExample();
        example.setLimit(queryImageDTO.getPageSize());
        example.setOffset(queryImageDTO.getOffset());
        example.createCriteria()
                .andScheduleTypeUuidEqualTo(queryImageDTO.getScheduleTypeUuid())
                .andDeletedEqualTo(CommonConstant.NOT_DELETED);
        return imageDao.selectByExample(example);
    }

    @Override
    public List<Image> findImagesByCreatorUUIDAndScheduleUUID(QueryImageDTO queryImageDTO) {
        ImageExample example = new ImageExample();
        example.setLimit(queryImageDTO.getPageSize());
        example.setOffset(queryImageDTO.getOffset());
        example.createCriteria()
                .andScheduleUuidEqualTo(queryImageDTO.getScheduleUuid())
                .andCreatorUuidEqualTo(queryImageDTO.getCreatorUuid())
                .andDeletedEqualTo(CommonConstant.NOT_DELETED);
        return imageDao.selectByExample(example);
    }

    @Override
    public boolean deleteImage(QueryImageDTO queryImageDTO) {
        try {
            Image targetImage = this.findImageByUuid(queryImageDTO);
            targetImage.setDeleted(CommonConstant.DELETED);

            System.out.println(targetImage.toString());

            ImageExample example = new ImageExample();
            example.createCriteria()
                    .andUuidEqualTo(queryImageDTO.getUuid());

            imageDao.updateByExampleSelective(targetImage, example);
            return true;
        } catch (Exception e) {
            log.debug("deleteImage exception==>" + e);
            return false;
        }
    }
}
