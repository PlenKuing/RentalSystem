package com.plenkuing.rentalSystem.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//房屋类
public class Room {


	
	private int id;
	private String address;
	//类型 单间 套间
	private String type;
	//可居住的人数
	private int count;
	//费用 按天算
	private double cost;
	//当前房屋的状态 可出租 暂不可租 已出租
	private String status;
	//屋主的ID
	private int hostId;
	//两张图片的路径
	private String image1;
	private String image2;
	private Host host;
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Room [id=" + id + ", address=" + address + ", type=" + type + ", count=" + count + ", cost=" + cost
				+ ", status=" + status + ", hostId=" + hostId + ", image1=" + image1 + ", image2=" + image2 + ", host="
				+ host + "]";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
		
	
	

}
