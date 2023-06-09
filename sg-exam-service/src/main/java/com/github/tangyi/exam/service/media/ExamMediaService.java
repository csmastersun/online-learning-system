package com.github.tangyi.exam.service.media;

import com.github.tangyi.api.user.enums.AttachTypeEnum;
import com.github.tangyi.api.user.model.Attachment;
import com.github.tangyi.api.user.service.IQiNiuService;
import com.github.tangyi.common.utils.SysUtil;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@Service
@AllArgsConstructor
public class ExamMediaService {

	private final IQiNiuService qiNiuService;

	public Attachment uploadVideo(MultipartFile file) {
		return upload(file, AttachTypeEnum.EXAM_VIDEO);
	}

	public Attachment uploadImage(MultipartFile file) {
		return upload(file, AttachTypeEnum.EXAM_IMAGE);
	}

	public Attachment upload(MultipartFile file, AttachTypeEnum type) {
		try {
			return qiNiuService.upload(file, type.getValue(), SysUtil.getUser(), SysUtil.getTenantCode());
		} catch (IOException e) {
			log.error("upload exam media failed, type: {}", type.getDesc(), e);
		}
		return null;
	}

	public String imageUrl(Long id) {
		return qiNiuService.getPreviewUrl(id);
	}

	public String videoUrl(Long id) {
		return qiNiuService.getPreviewUrl(id);
	}
}
