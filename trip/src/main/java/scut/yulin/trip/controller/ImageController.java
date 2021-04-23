package scut.yulin.trip.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import scut.yulin.common.vo.ResponseVO;
import scut.yulin.trip.dto.image.InsertImageDTO;
import scut.yulin.trip.dto.image.QueryImageDTO;
import scut.yulin.trip.service.ImageService;

/**
 * @date 2021/04/20
 * image图片基础controller
 */
@RestController
@RequestMapping("base")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("image")
    public ResponseVO addNewImage(@RequestBody InsertImageDTO insertImageDTO) {
        if (imageService.addNewImage(insertImageDTO) == 1) {
            return ResponseVO.success("add new image ok");
        }
        return ResponseVO.failed("add new image failed");
    }

    @GetMapping("image")
    public ResponseVO findImageByUuid(@RequestBody QueryImageDTO queryImageDTO) {
        return ResponseVO.success(imageService.findImageByUuid(queryImageDTO));
    }

    @GetMapping("image/list/scheduleUUID")
    public ResponseVO findImagesByScheduleUUID(@RequestBody QueryImageDTO queryImageDTO) {
        return ResponseVO.success(imageService.getImageListByScheduleUUID(queryImageDTO));
    }

    @DeleteMapping("image")
    public ResponseVO deleteImage(@RequestBody QueryImageDTO queryImageDTO) {
        if (imageService.deleteImage(queryImageDTO)) {
            return ResponseVO.success("delete image ok");
        }
        return ResponseVO.failed("delete image failed");
    }
}
