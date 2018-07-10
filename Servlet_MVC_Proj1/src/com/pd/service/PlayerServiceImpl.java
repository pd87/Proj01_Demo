package com.pd.service;

import com.pd.beans.DTO;
import com.pd.dao.Player_inter;
import com.pd.dao.Players_dao;

public class PlayerServiceImpl implements PlayerService {

	@Override
	public int insert(DTO dto) throws Exception {
		Player_inter obj=new Players_dao();
		int count=obj.insert(dto);
/*
 * total=dto.getM1()+m2()+m3()/3;
 * 
 * 		Bo b=new new Bo();
 * b.setPER(total);
 * int count=obj.insert(b);
 */
		
		return count;
	}

}
