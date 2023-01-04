package com.myet.basic.lifetip;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myet.basic.dto.LifetipDTO;
import com.myet.basic.util.Criteria;

@Mapper
public interface LifetipMapper {

	public List<LifetipDTO> lifetipListAll(Criteria cri);  // 전체 목록 조회
	public boolean lifetipInsert(LifetipDTO dto);  // 글 등록
	public LifetipDTO lifetipDetail(int lt_num);  // 글 상세조회
	public boolean lifetipUpdate(LifetipDTO dto);  // 글 수정
	public boolean lifetipDelete(int lt_num); // 글 삭제
	public int lifetipTotal(Criteria cri);// 전체 게시글 수
	public int lifetipViewCount(int lt_num); // 조회수 증가
}
