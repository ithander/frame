package com.zbsg.finance.card.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.zbsg.common.model.Action;
import com.zbsg.common.model.ActionValues;
import com.zbsg.finance.card.bean.Card;
import com.zbsg.finance.card.service.CardService;

@RestController
@RequestMapping("cards")
public class CardAction extends Action {

	@Autowired
	private CardService cardService;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<Card> list(HttpServletRequest request){
		ActionValues values=getValues(request);
		cardService.list(values);
		return null;
	}
	
	
}
