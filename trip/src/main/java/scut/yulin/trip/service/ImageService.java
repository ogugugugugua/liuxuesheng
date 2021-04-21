package scut.yulin.trip.service;

import scut.yulin.trip.dto.image.InsertImageDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.model.Image;

import java.util.List;

/**
 * @date 2021/04/19
 */

public interface ImageService {
    public int addNewImage(InsertImageDTO insertImageDTO);

    public Image findImageByUuid(QueryImageDTO queryImageDTO);

    public List<Image> findImagesByScheduleUUID(QueryImageDTO queryImageDTO);

    List<Image> findImagesByScheduleTypeUUID(QueryImageDTO queryImageDTO);

    List<Image> findImagesByCreatorUUIDAndScheduleUUID(QueryImageDTO queryImageDTO);

    public boolean deleteImage(QueryImageDTO queryImageDTO);
}