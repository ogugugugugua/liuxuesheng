package scut.yulin.trip.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @date 2021/04/19
 */
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    @Override
    public int addNewImage(InsertImageDTO insertImageDTO) {
        String creatorUuid = insertImageDTO.getCreatorUuid();
        String scheduleUuid = insertImageDTO.getScheduleUuid();
        String scheduleTypeUuid = insertImageDTO.getScheduleTypeUuid();
        String name = Inspections.isNotBlank(insertImageDTO.getName()) ? insertImageDTO.getName() : "";
        String url = insertImageDTO.getUrl();
        String headImage = Inspections.isNotBlank(insertImageDTO.getHeadImage()) ? "1" : "0";

        Assert.notBlank(creatorUuid);
        Assert.notBlank(scheduleUuid);
        Assert.notBlank(scheduleTypeUuid);
        Assert.notBlank(name);
        Assert.notBlank(url);
        Assert.notBlank(headImage);

        Image image = new Image(IdUtil.randomUUID(),
                scheduleUuid,
                scheduleTypeUuid,
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
    public List<Image> findImagesByScheduleTypeAndScheduleUUID(QueryImageDTO queryImageDTO) {
        ImageExample example = new ImageExample();
        example.setLimit(queryImageDTO.getPageSize());
        example.setOffset(queryImageDTO.getOffset());
        example.createCriteria()
                .andScheduleTypeUuidEqualTo(queryImageDTO.getScheduleTypeUuid())
                .andScheduleUuidEqualTo(queryImageDTO.getScheduleUuid())
                .andDeletedEqualTo(CommonConstant.NOT_DELETED);
        return imageDao.selectByExample(example);
    }
}
