package com.plenkuing.rentalSystem.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

//订单类
public class Order {

	private int id;
	//交易的时间
	private Date time;
	//类型 单间 套间
	private int roomId;
	//学生Id
	private int studentId;
	//房主ID
	private int hostId;
	
	private Room room;
	private Student student;
	private Host host;
	
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", time=" + time + ", roomId=" + roomId + ", studentId=" + studentId + ", hostId="
				+ hostId + ", room=" + room + ", student=" + student + ", host=" + host + "]";
	}

	
	
}
