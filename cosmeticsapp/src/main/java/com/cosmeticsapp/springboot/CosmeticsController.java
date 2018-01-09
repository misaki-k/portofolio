package com.cosmeticsapp.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;



@Controller
public class CosmeticsController {
	
	@Autowired
	HttpSession session;
	
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value="/", method=RequestMethod.POST)
	public ModelAndView send(ModelAndView mv) {
		mv.setViewName("redirect:quiz");
		return mv;
	}
	
	@RequestMapping(value="/quiz", method=RequestMethod.GET)
	
	public ModelAndView quiz(ModelAndView mv) {
		mv.setViewName("quiz");
		mv.addObject("css","quiz");
		mv.addObject("msg","あなたのスキントーンは？");
		mv.addObject("radio1","radio");
		mv.addObject("radio2","radio");
		mv.addObject("radio3","radio");
		mv.addObject("radio4","radio");
		mv.addObject("radio5","radio");
		mv.addObject("circle1", "faircircle");
		mv.addObject("circle2", "lightcircle");
		mv.addObject("circle3", "mediumcircle");
		mv.addObject("circle4", "tanolivecircle");
		mv.addObject("circle5", "deepcircle");
		mv.addObject("question1","FAIR");
		mv.addObject("question2","LIGHT");
		mv.addObject("question3","MEDIUM");
		mv.addObject("question4","TAN/OLIVE");
		mv.addObject("question5","DEEP");
		mv.addObject("value1","fair");
		mv.addObject("value2","light");
		mv.addObject("value3","medium");
		mv.addObject("value4","tanolive");
		mv.addObject("value5","deep");
		return mv;
	}
	
	@RequestMapping(value="/quiz", method=RequestMethod.POST)
	public ModelAndView sendQuiz(@RequestParam("q1") String skintoneAnswer,ModelAndView mv) {	
		
		//ここで答えを代入
		String ans1 = skintoneAnswer;
		
		//答えを設定
		session.setAttribute("ans1",ans1);
		
		mv.setViewName("redirect:quiz2");
		return mv;
	}
	
	@RequestMapping(value="/quiz2", method=RequestMethod.GET)
	public ModelAndView quiz2(ModelAndView mv) {
		mv.setViewName("quiz2");
		mv.addObject("css","quiz2");
		mv.addObject("msg","あなたのスキンタイプは？");
		mv.addObject("radio1","radio");
		mv.addObject("radio2","radio");
		mv.addObject("radio3","radio");
		mv.addObject("radio4","radio");
		mv.addObject("question1","DRY");
		mv.addObject("question2","NORMAL");
		mv.addObject("question3","OILY");
		mv.addObject("question4","COMBINATION");
		mv.addObject("value1","dry");
		mv.addObject("value2","normal");
		mv.addObject("value3","oily");
		mv.addObject("value4","combination");
		return mv;
	}
	@RequestMapping(value="/quiz2", method=RequestMethod.POST)
	public ModelAndView sendQuiz2(@RequestParam("q2") String skintypeAnswer,ModelAndView mv) {
		
				
		//ここで答えを代入
		String ans2 = skintypeAnswer;
				
		//答えを設定
		session.setAttribute("ans2",ans2);
		
		
		mv.setViewName("redirect:quiz3");
		return mv;
	}
	@RequestMapping(value="/quiz3", method=RequestMethod.GET)
	public ModelAndView quiz3(ModelAndView mv) {
		mv.setViewName("quiz3");
		mv.addObject("quiz", "quiz4");
		mv.addObject("css","quiz3");
		mv.addObject("msg","求めるカバー力はどのくらい？");
		mv.addObject("radio1","radio");
		mv.addObject("radio2","radio");
		mv.addObject("radio3","radio");
		mv.addObject("question1","FULL");
		mv.addObject("question2","MEDIUM");
		mv.addObject("question3","SHEER");
		mv.addObject("value1","full");
		mv.addObject("value2","medium");
		mv.addObject("value3","sheer");
		return mv;
	}
	@RequestMapping(value="/quiz3", method=RequestMethod.POST)
	public ModelAndView sendQuiz3(@RequestParam("q3") String coverageAnswer,ModelAndView mv) {
				
		//ここで答えを代入
		String ans3 = coverageAnswer;
				
		//答えを設定
		session.setAttribute("ans3",ans3);
		
		
		mv.setViewName("redirect:quiz4");
		return mv;
	}
	
	@RequestMapping(value="/quiz4", method=RequestMethod.GET)
	public ModelAndView quiz4(ModelAndView mv) {
		mv.setViewName("quiz4");
		mv.addObject("css","quiz4");
		mv.addObject("msg","求める仕上がりは？");
		mv.addObject("radio1","radio");
		mv.addObject("radio2","radio");
		mv.addObject("radio3","radio");
		mv.addObject("radio4","radio");
		mv.addObject("question1","MATTE");
		mv.addObject("question2","NATURAL");
		mv.addObject("question3","RADIANT");
		mv.addObject("question4","SATIN");
		mv.addObject("value1","matte");
		mv.addObject("value2","natural");
		mv.addObject("value3","radiant");
		mv.addObject("value4","satin");
		return mv;
	}
	
	@RequestMapping(value="/quiz4", method=RequestMethod.POST)
	public ModelAndView sendQuiz4(@RequestParam("q4") String finishAnswer,ModelAndView mv) {
		
		//ここで答えを代入
		String ans4 = finishAnswer;
				
		//答えを設定
		session.setAttribute("ans4",ans4);
		
		
		mv.setViewName("redirect:result");
		
		
		
		
		return mv;
	}
	
	@RequestMapping(value="/result", method=RequestMethod.GET)
	public ModelAndView result(ModelAndView mv) {
		
		//スキントーン
		String ans1 = (String)session.getAttribute("ans1");
		//スキンタイプ
		String ans2 = (String)session.getAttribute("ans2");
		//カバー力
		String ans3 = (String)session.getAttribute("ans3");
		//仕上がり
		String ans4 = (String)session.getAttribute("ans4");
		
		
		
		Connectdb dbOpe = new Connectdb();
		
		dbOpe.dbaccess();
		Data data = new Data(ans1,ans2,ans3,ans4);
		ArrayList<CosmeData> dataList = dbOpe.getData(data);
		dbOpe.close();
		
		
		
		session.invalidate();
		
			
		mv.setViewName("result");
		mv.addObject("dl", dataList);
		return mv;
	}
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	public ModelAndView sendresult(ModelAndView mv) {
		

		
		mv.setViewName("result");
		return mv;
	}
	
	
}
