package com.project.jee.darrasjee.mapper;

import com.project.jee.darrasjee.domain.AccessKey;
import com.project.jee.darrasjee.dto.AccessKeyDto;
import org.springframework.stereotype.Service;

@Service
public class AccessKeyDtoMapper {

        public static AccessKeyDto mapToAccessKeyDto(AccessKey accessKey) {
                return AccessKeyDto.builder()
                        .id(accessKey.getId())
                        .carPackage(accessKey.getCarPackage())
                        .hours(accessKey.getHours())
                        .build();
        }

}
