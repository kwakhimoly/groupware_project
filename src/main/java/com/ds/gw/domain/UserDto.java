package com.ds.gw.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
	String user_id;
	String user_nm;
	int user_dept_se_no;
	String user_dept;
	String user_eml_addr;
	String user_telno;
	String user_addr;
	String user_aprv_yn;
	String user_hobby;
}
