package com.zbsg.finance.card.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zbsg.common.dao.BaseDao;
import com.zbsg.common.model.ActionValues;
import com.zbsg.finance.card.bean.Card;

@Service
@Transactional
public class CardService extends BaseDao{

	public List<Card> list(ActionValues values){
		return null;
	}
	
}
