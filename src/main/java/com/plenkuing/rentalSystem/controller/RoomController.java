package com.plenkuing.rentalSystem.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.plenkuing.rentalSystem.entity.Room;
import com.plenkuing.rentalSystem.service.RoomService;

@Controller

public class RoomController {
	@Autowired
	RoomService roomService;

	// 分页显示房屋信息
	@RequestMapping(value = "/roomInfo", method = RequestMethod.GET)
	public String roomInfo(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {

		PageHelper.startPage(pageNum, 5);// 设置开始的页数 以及每次显示的页数
		// 用PageInfo对结果进行包装 后一个参数表示连续传入的页数
		List<Room> rooms = roomService.getRoomInfo();
		PageInfo<Room> pageInfo = new PageInfo<Room>(rooms, 5);
		// 测试PageInfo全部属性
		model.addAttribute("pageInfo", pageInfo);
		return "roomInfo";
	}

	// 显示屋主的房屋 也是一个分页请求
	@RequestMapping(value = "/hostRoom/{hostId}", method = RequestMethod.GET)
	public String hostRoom(@PathVariable int hostId,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Model model) {
		// 分页设置
		PageHelper.startPage(pageNum, 5);
		// 获取数据
		List<Room> rooms = roomService.getRoomByHostId(hostId);
		// 封装成pageInfo
		PageInfo<Room> pageInfo = new PageInfo<Room>(rooms, 5);
		model.addAttribute("pageInfo", pageInfo);
		return "hostRoom";
	}

	// 显示修改房屋信息的界面
	@RequestMapping(value = "/updateRoom/{roomId}", method = RequestMethod.GET)
	public String updateRoom(@PathVariable int roomId, HttpSession session, Model model) {

		Room room = roomService.getRoomById(roomId);
		model.addAttribute("room", room);
		// 跳转到注册的页面
		return "updateRoom";

	}

	// 提交修改房屋的表单处理
	@RequestMapping(value = "/updateRoom/{roomId}", method = RequestMethod.POST)
	public String processUpdateRoom(@PathVariable int roomId, @Valid Room room,
			@RequestParam("img1") MultipartFile file1, @RequestParam("img2") MultipartFile file2, Errors errors,
			HttpSession session) throws Exception, IOException {

		if (errors.hasErrors()) {
			System.out.println("出错了");
			return "/updateRoom/" + roomId;
		} else {
			// 上传文件路径 保存在外部磁盘上
			String path = "E:\\roomPhotos";
			String image1 = null;
			String image2 = null;
			// 如果文件不为空，写入上传路径
			if (!file1.isEmpty()) {
				// 上传文件名
				String filename = file1.getOriginalFilename();
				// 重命名图片
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + filename;
				String type = file1.getContentType();
				// 使用MD5工具进行重写
				String file_ture_name = DigestUtils.md5DigestAsHex(time.getBytes());
				if (type.equals("image/jpeg")) {
					file_ture_name = file_ture_name.concat(".jpg");
				} else if (type.equals("image/png")) {
					file_ture_name = file_ture_name.concat(".png");
				} else if (type.equals("image/bmp")) {
					file_ture_name = file_ture_name.concat(".bmp");
				} else if (type.equals("image/gif")) {
					file_ture_name = file_ture_name.concat(".gif");
				} else
					file_ture_name = file_ture_name.concat(".jpg");
				File filepath = new File(path, file_ture_name);
				// 判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) {
					filepath.getParentFile().mkdirs();
				}
				// 将上传文件保存到一个目标文件当中
				file1.transferTo(new File(path + File.separator + file_ture_name));
				image1 = filepath.getAbsolutePath();
			}
			if (!file2.isEmpty()) {
				// 上传文件名
				String filename = file2.getOriginalFilename();
				// 重命名图片
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + filename;
				String type = file2.getContentType();
				// 使用MD5工具进行重写
				String file_ture_name = DigestUtils.md5DigestAsHex(time.getBytes());

				if (type.equals("image/jpeg")) {
					file_ture_name = file_ture_name.concat(".jpg");
				} else if (type.equals("image/png")) {
					file_ture_name = file_ture_name.concat(".png");
				} else if (type.equals("image/bmp")) {
					file_ture_name = file_ture_name.concat(".bmp");
				} else if (type.equals("image/gif")) {
					file_ture_name = file_ture_name.concat(".gif");
				} else
					file_ture_name = file_ture_name.concat(".jpg");

				File filepath = new File(path, file_ture_name);
				// 判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) {
					filepath.getParentFile().mkdirs();
				}
				// 将上传文件保存到一个目标文件当中
				file2.transferTo(new File(path + File.separator + file_ture_name));
				image2 = filepath.getAbsolutePath();
			}
			String hostId = (String) session.getAttribute("id");
			System.out.println(room);
			room.setId(roomId);
			room.setImage1(image1);
			room.setImage2(image2);
			roomService.updateRoomInfo(room);
			System.out.println("修改成功");
			return "redirect:/hostRoom/" + hostId;
		}

	}

	// 删除房屋信息
	@RequestMapping(value = "/deleteRoom/{roomId}", method = RequestMethod.GET)
	public String deleteRoom(@PathVariable int roomId, HttpSession session) {
		roomService.deleteRoomInfo(roomId);
		String hostId = (String) session.getAttribute("id");
		return "redirect:/hostRoom/" + hostId;
	}

	// 显示新增房屋界面
	@RequestMapping(value = "/addRoom", method = RequestMethod.GET)
	public String addRoom(Model model) {
		model.addAttribute(new Room());

		return "addRoom";
	}

	// 新增房屋信息 包含文件上传
	@RequestMapping(value = "/addRoom", method = RequestMethod.POST)
	public String addRoom(@Valid Room room, Errors errors, @RequestParam("img1") MultipartFile file1,
			@RequestParam("img2") MultipartFile file2, HttpSession session, HttpServletRequest request)
			throws Exception, IOException {

		if (errors.hasErrors()) {
			return "addRoom";
		} else {
			// 上传文件路径 保存在外部磁盘上
			String path = "E:\\roomPhotos";
			String image1 = null;
			String image2 = null;
			// 如果文件不为空，写入上传路径
			if (!file1.isEmpty()) {
				// 上传文件名
				String filename = file1.getOriginalFilename();
				// 重命名图片
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + filename;
				String type = file1.getContentType();
				// 使用MD5工具进行重写
				String file_ture_name = DigestUtils.md5DigestAsHex(time.getBytes());
				if (type.equals("image/jpeg")) {
					file_ture_name = file_ture_name.concat(".jpg");
				} else if (type.equals("image/png")) {
					file_ture_name = file_ture_name.concat(".png");
				} else if (type.equals("image/bmp")) {
					file_ture_name = file_ture_name.concat(".bmp");
				} else if (type.equals("image/gif")) {
					file_ture_name = file_ture_name.concat(".gif");
				} else
					file_ture_name = file_ture_name.concat(".jpg");
				File filepath = new File(path, file_ture_name);
				// 判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) {
					filepath.getParentFile().mkdirs();
				}
				// 将上传文件保存到一个目标文件当中
				file1.transferTo(new File(path + File.separator + file_ture_name));
				image1 = filepath.getAbsolutePath();
			}
			if (!file2.isEmpty()) {
				// 上传文件名
				String filename = file2.getOriginalFilename();
				// 重命名图片
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + filename;
				String type = file2.getContentType();
				// 使用MD5工具进行重写
				String file_ture_name = DigestUtils.md5DigestAsHex(time.getBytes());

				if (type.equals("image/jpeg")) {
					file_ture_name = file_ture_name.concat(".jpg");
				} else if (type.equals("image/png")) {
					file_ture_name = file_ture_name.concat(".png");
				} else if (type.equals("image/bmp")) {
					file_ture_name = file_ture_name.concat(".bmp");
				} else if (type.equals("image/gif")) {
					file_ture_name = file_ture_name.concat(".gif");
				} else
					file_ture_name = file_ture_name.concat(".jpg");

				File filepath = new File(path, file_ture_name);
				// 判断路径是否存在，如果不存在就创建一个
				if (!filepath.getParentFile().exists()) {
					filepath.getParentFile().mkdirs();
				}
				// 将上传文件保存到一个目标文件当中
				file2.transferTo(new File(path + File.separator + file_ture_name));
				image2 = filepath.getAbsolutePath();
			}
			System.out.println("主图:" + image1);
			System.out.println("附图:" + image2);

			String hostId = (String) session.getAttribute("id");
			room.setHostId(Integer.parseInt(hostId));
			room.setImage1(image1);
			room.setImage2(image2);
			System.out.println(room);
			roomService.saveRoomInfo(room);
			return "redirect:/hostRoom/" + hostId;

		}
	}

}
