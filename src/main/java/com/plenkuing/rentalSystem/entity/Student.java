package com.plenkuing.rentalSystem.entity;



import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.plenkuing.rentalSystem.controller.ValidGroup.ValidGroup1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	
	private int id;
	
	@NotEmpty(message="名字不能为空",groups= {ValidGroup1.class})
	@Size(min=1,max=30,message="名字长度应为1-30",groups= {ValidGroup1.class})
	private String name;
	
	@NotEmpty(message="地址不能为空",groups= {ValidGroup1.class})
	@Size(min=6,max=60,message="地址长度应为6-60",groups= {ValidGroup1.class})
	private String address;
	
	@NotEmpty(message="手机号码不能为空",groups= {ValidGroup1.class})
	@Size(min=6,max=20,message="电话长度应为6-20",groups= {ValidGroup1.class})
	private String phone;
	
	@NotNull(message="生日不能为空",groups= {ValidGroup1.class})
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	
	@NotEmpty(message="生日不能为空",groups= {ValidGroup1.class})
	private String gender;
	
	@NotEmpty(message="密码不能为空")
	@Size(min=6,max=100,message="电话长度应为6-100")
	private String password;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", birthday="
				+ birthday + ", gender=" + gender + ", password=" + password + "]";
	}

	
	
}
