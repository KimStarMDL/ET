package com.myet.basic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myet.basic.dto.LifetipDTO;
import com.myet.basic.lifetip.LifetipService;
import com.myet.basic.util.Criteria;
import com.myet.basic.util.PageDTO;

@Controller
public class LifetipController {

	@Autowired
	LifetipService lifetipService;

	@GetMapping("/lifetipListAll")
	public String lifetipListAll(Model model, @ModelAttribute("cri") Criteria cri) {
		
		List<LifetipDTO> list = lifetipService.lifetipListAll(cri);  // 데이터
		
		int total = lifetipService.lifetipTotal(cri);  // 전체 게시글 수
		PageDTO pageDTO = new PageDTO(cri, total);
		
		model.addAttribute("pageDTO", pageDTO);
		model.addAttribute("lt_list", list);
		
		return "lifetipListAll";
	}
	
	@GetMapping("/lifetipInsert")
	public String lifetipInsert() {
		
		
		return "lifetipInsert";
	}
	
	@PostMapping("/lifetipInsert")
	public String lifetiptInsertForm(LifetipDTO dto) {
		
		boolean result = lifetipService.lifetipInsert(dto);
			
		return "redirect:/lifetipListAll";
	}
	
	@GetMapping("/lifetipDetail")
	public String lifetipDetail(@RequestParam("lt_num") int lt_num, Model model) {
		
		System.out.print("lt_num" + lt_num);
		
		LifetipDTO detail = lifetipService.lifetipDetail(lt_num);
		
		System.out.print(detail.toString());
		
		model.addAttribute("lt_detail", detail);
		
		return "lifetipDetail";
	}
	
	@GetMapping("/lifetipUpdate")
	public String lifetipUpdate(Model model, @RequestParam("lt_num") int num) {
			
		
			LifetipDTO update = lifetipService.lifetipDetail(num);
			model.addAttribute("update", update);
		 
		
		return "lifetipUpdate";
	}
	
	@PostMapping("/lifetipUpdateForm")
	public String lifetipUpdateForm(LifetipDTO dto, RedirectAttributes RA) {
		
		
		boolean result = lifetipService.lifetipUpdate(dto);
		
		if(result) {
			RA.addFlashAttribute("msg", "수정되었습니다.");
		} else {
			RA.addFlashAttribute("msg", "수정에 실패했습니다.");
		}
		 RA.addAttribute("lt_num", dto.getLt_num());
		return "redirect:/lifetipDetail";
	}
	
	@GetMapping("/lifetipDelete")
	public String lifetipDelete(@RequestParam("lt_num") int lt_num) {
		
		lifetipService.lifetipDelete(lt_num);
		
		return "redirect:/lifetipListAll";
	}
	
}

