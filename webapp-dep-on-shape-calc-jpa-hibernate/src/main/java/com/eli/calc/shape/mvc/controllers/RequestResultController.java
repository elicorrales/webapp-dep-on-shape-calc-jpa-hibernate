package com.eli.calc.shape.mvc.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eli.calc.shape.domain.CalculationRequest;
import com.eli.calc.shape.domain.CalculationResult;
import com.eli.calc.shape.model.CalcType;
import com.eli.calc.shape.model.ShapeName;
import com.eli.calc.shape.service.ShapeCalculatorService;


@Controller
public class RequestResultController {

	@Autowired
	private ShapeCalculatorService calculator;
	
    @RequestMapping(value="/newreq", method = RequestMethod.GET)
    public String viewRequest(Map<String, Object> model) {
    	
    	System.err.println("\n\n\nINSIDE Controller viewRequest()\n\n\n");
        CalculationRequest calcRequestForm = new CalculationRequest();
        model.put("calcRequestForm", calcRequestForm);
         
        List<String> shapeList = new ArrayList<>();
        for (ShapeName name : ShapeName.values()) {
        	shapeList.add(name.name());
        }
        model.put("shapeList", shapeList);
 
        List<String> calcTypeList = new ArrayList<>();
        for (CalcType type : CalcType.values()) {
        	calcTypeList.add(type.name());
        }
        model.put("calcTypeList", calcTypeList);
 
        return "NewRequest";
    }
 
    @RequestMapping(value="/newreq", method = RequestMethod.POST)
    public String processRequest(
    		//@ModelAttribute("calcRequestForm") CalculationRequestImpl calcRequestForm,
    		@ModelAttribute("calcRequestForm") CalculationRequest calcRequestForm,
            Map<String, Object> model
            ) {
         
    	System.err.println("\n\n\nINSIDE Controller processRequest()\n\n\n");

    	this.calculator.queueCalculationRequest(
    			calcRequestForm.getShapeName(),
    			calcRequestForm.getCalcType(),
    			calcRequestForm.getDimension());
 
        List<String> shapeList = new ArrayList<>();
        for (ShapeName name : ShapeName.values()) {
        	shapeList.add(name.name());
        }
        model.put("shapeList", shapeList);
 
        List<String> calcTypeList = new ArrayList<>();
        for (CalcType type : CalcType.values()) {
        	calcTypeList.add(type.name());
        }
        model.put("calcTypeList", calcTypeList);

        return "NewRequest";
    }


	@RequestMapping(value="/curreq",method=RequestMethod.GET)
	public ModelAndView listPendingRequests() {

    	System.err.println("\n\n\nINSIDE Controller listPendingRequests()\n\n\n");

    	List<CalculationRequest> calcReqList = this.calculator.getAllPendingRequests();

		if (null==calcReqList || calcReqList.isEmpty()) {
			return new ModelAndView("CurrentRequests","message", "There are NO Pending CalculationRequests");
		}

		return new ModelAndView("CurrentRequests","calcReqList",calcReqList);

	}



	@RequestMapping(value="/results",method=RequestMethod.GET)
	public ModelAndView listResults() {

    	System.err.println("\n\n\nINSIDE Controller listResults()\n\n\n");

    	this.calculator.runAllPendingRequestsNoStopOnError();

    	//Map<CalculationRequest,CalculationResult> results = this.calculator.getShapeCalculationResults();
    	List<CalculationResult> results = this.calculator.getAllCalculationResults();

		if (null==results || results.isEmpty()) {
			return new ModelAndView("Results","message", "There are NO Results Yet");
		}

   		//List<CalculationResult> resultsList = new ArrayList<CalculationResult>();
   		//for (CalculationResult result : results.values() ) { resultsList.add(result); }

		//return new ModelAndView("Results","resultsList",resultsList);
		return new ModelAndView("Results","resultsList",results);

	}

	@RequestMapping(value="/delallres",method=RequestMethod.POST)
	public ModelAndView deleteAllResults() {

    	System.err.println("\n\n\nINSIDE Controller deleteAllResults()\n\n\n");

    	this.calculator.deleteAllResults();

    	//Map<CalculationRequest,CalculationResult> results = this.calculator.getShapeCalculationResults();
    	List<CalculationResult> results = this.calculator.getAllCalculationResults();

		if (null==results || results.isEmpty()) {
			return new ModelAndView("Results","message", "There are NO Results Yet");
		}

   		//List<CalculationResult> resultsList = new ArrayList<CalculationResult>();
   		//for (CalculationResult result : results.values() ) { resultsList.add(result); }

		//return new ModelAndView("Results","resultsList",resultsList);
		return new ModelAndView("Results","resultsList",results);

	}

}
