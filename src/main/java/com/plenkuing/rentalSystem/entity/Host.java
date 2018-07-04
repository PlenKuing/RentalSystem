package com.plenkuing.rentalSystem.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.plenkuing.rentalSystem.controller.ValidGroup.ValidGroup1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//屋主类
public class Host {
		
		private int id;
		
		@NotEmpty(groups= {ValidGroup1.class})
		@Size(min=1,max=30,groups= {ValidGroup1.class})
		private String name;
		
		@NotEmpty(groups= {ValidGroup1.class})
		@Size(min=5,max=30,groups= {ValidGroup1.class})
		private String address;
		
		@NotEmpty(groups= {ValidGroup1.class})
		@Size(min=5,max=20,groups= {ValidGroup1.class})
		private String phone;
		
		@NotEmpty
		@Size(min=6,max=100)
		private String password;
	
		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "Host [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", password="
					+ password + "]";
		}
		

}
