package com.myet.basic.lifetip;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myet.basic.dto.LifetipDTO;
import com.myet.basic.util.Criteria;

@Service
public class LifetipServiceImpl implements LifetipService {

	@Autowired
	LifetipMapper lifetipMapper;
	
	@Override
	public List<LifetipDTO> lifetipListAll(Criteria cri) {
		// TODO Auto-generated method stub
		return lifetipMapper.lifetipListAll(cri);
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public boolean lifetipInsert(LifetipDTO dto) {
		// TODO Auto-generated method stub
		return lifetipMapper.lifetipInsert(dto);
	}

	@Override
	public LifetipDTO lifetipDetail(int lt_num) {
		// TODO Auto-generated method stub
		return lifetipMapper.lifetipDetail(lt_num);
	}

	@Override
	public boolean lifetipUpdate(LifetipDTO dto) {
		// TODO Auto-generated method stub
		return lifetipMapper.lifetipUpdate(dto);
	}

	@Override
	public boolean lifetipDelete(int lt_num) {
		// TODO Auto-generated method stub
		return lifetipMapper.lifetipDelete(lt_num);
	}

	@Override
	public int lifetipTotal(Criteria cri) {

		return lifetipMapper.lifetipTotal(cri);
	}

	@Override
	public int lifetipViewCount(int lt_num) {
		
		return lifetipMapper.lifetipViewCount(lt_num);
	}


}
