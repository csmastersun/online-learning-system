package com.github.tangyi.api.user.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysMessageUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
}
