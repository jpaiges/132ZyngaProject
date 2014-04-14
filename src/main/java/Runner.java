package main.java;

import static spark.Spark.*;
import spark.*;
import spark.template.velocity.VelocityRoute;
import weka.classifiers.Classifier;
import weka.core.Attribute;
import weka.core.FastVector;
import weka.core.Instance;
import weka.core.Instances;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;


public class Runner {
	public static Classifier MyClassifier;
    
	public static void main(String[] args) throws JsonSyntaxException, MalformedURLException, IOException {
		// 1) Change WekaProcessing main function's return type to Classifer, change name?
		// 2) Make function return classifier
		// c = (new WekaProcessing()).train()
		// 3) create a new POST route (JsonTransformer)
		// 			in this function, parse JSON from request body
		//          create Instance() out of it (weka class)
		//			pass it into c.classifyInstance()
		//			create a Java class similar to MyMessage that will have instance variables for the attributes
		//			of your response
		//			return an instance of this class to generate a response
		//	handle in client-side javascript
		
        try {
        	MyClassifier = (new WekaProcessing()).train();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// TODO Auto-generated method stub
		get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
	            return "Hello World!";
            }
        });
		
		/*get(new JsonTransformerRoute("/hello") {
         @Override
         public Object handle(Request request, Response response) {
         return new MyMessage("Hello World");
         }
		 });*/
		
		get(new VelocityRoute("/hello1") {
            @Override
            public Object handle(final Request request, final Response response) {
                Map<String, Object> model = new HashMap<>();
                model.put("hello", "Velocity World");
                model.put("m", new MyMessage("hi bro"));
                // The wm files are located under the resources directory
                return modelAndView(model, "hello.wm");
            }
        });
		
		post(new JsonTransformerRoute("/hello") {
		    @Override
		    public Object handle (Request request, Response response) {
		    	double result = -1;

                Map<String, Object> model = new HashMap<>();
		    	Gson gson = new Gson();
			    DataObject mydata = gson.fromJson(request.body(), DataObject.class);
		    	System.out.println(mydata.toString());
		    	/* Creating an instance with our values */
		    	//declare attributes
		    	Attribute tenure = new Attribute("tenure");
		    	Attribute is30dPayer = new Attribute("is30dPayer");
		    	Attribute paymentAmount30d = new Attribute("paymentAmount30d");
		    	Attribute engmtLastWk = new Attribute("engmtLastWk");
		    	Attribute engmtWk_1 = new Attribute("engmtWk-1");
		    	Attribute engmtWk_2 = new Attribute("engmtWk-2");
		    	Attribute engmtWk_3 = new Attribute("engmtWk-3");
		    	Attribute engmt28d = new Attribute("engmt28d");
		    	Attribute deltaEngmt4wk = new Attribute("deltaEngmt4wk");
		    	Attribute socialActionsReceivedLastWk = new Attribute("socialActionsReceivedLastWk");
		    	Attribute socialActorsReceivedLastWk = new Attribute("socialActorsReceivedLastWk");
		    	Attribute socialActionsSentLastWk = new Attribute("socialActionsSentLastWk");
		    	Attribute socialActorsSentLastWk = new Attribute("socialActorsSentLastWk");
		    	Attribute daysSinceLastSend = new Attribute("daysSinceLastSend");
		    	Attribute daysSinceLastReceive = new Attribute("daysSinceLastReceive");
		    	FastVector attributeList = new FastVector(15);
                
	            /*ArrayList<String> classVal = new ArrayList<String>();
                 classVal.add("ClassA");
                 classVal.add("ClassB");*/
	            
	            FastVector fvNominalVal = new FastVector(2);
	            fvNominalVal.addElement("non-lapser");
	            fvNominalVal.addElement("lapser");
	            Attribute attribute1 = new Attribute("trueLapse", fvNominalVal);
	            
		    	attributeList.addElement(tenure);
		    	attributeList.addElement(is30dPayer);
		    	attributeList.addElement(paymentAmount30d);
		    	attributeList.addElement(engmtLastWk);
		    	attributeList.addElement(engmtWk_1);
		    	attributeList.addElement(engmtWk_2);
		    	attributeList.addElement(engmtWk_3);
		    	attributeList.addElement(engmt28d);
		    	attributeList.addElement(deltaEngmt4wk);
		    	attributeList.addElement(socialActionsReceivedLastWk);
		    	attributeList.addElement(socialActorsReceivedLastWk);
		    	attributeList.addElement(socialActionsSentLastWk);
		    	attributeList.addElement(socialActorsSentLastWk);
		    	attributeList.addElement(daysSinceLastSend);
		    	attributeList.addElement(daysSinceLastReceive);
		    	attributeList.addElement(attribute1);
		    	
                
		    	Instance inst = new Instance(15);
		        
		    	Instances data = new Instances("TestInstances",attributeList,15);
		    	data.setClassIndex(data.numAttributes()-1);
                
		    	//set attributes into instance
		    	System.out.println("The instance: " + inst);
		    	System.out.println("tenure data: " + mydata.gettenure());
		    	inst.setValue(tenure, mydata.gettenure());
		    	System.out.println("=====");
		    	inst.setValue(is30dPayer, mydata.getis30dPayer());
		    	inst.setValue(paymentAmount30d, mydata.getpaymentAmount30d());
		    	inst.setValue(engmtLastWk, mydata.getengmtLastWk());
		    	inst.setValue(engmtWk_1, mydata.getengmtWk_1());
		    	inst.setValue(engmtWk_2, mydata.getengmtWk_2());
		    	inst.setValue(engmtWk_3, mydata.getengmtWk_3());
		    	inst.setValue(engmt28d, mydata.getengmt28d());
		    	inst.setValue(deltaEngmt4wk, mydata.getdeltaEngmt4wk());
		    	inst.setValue(socialActionsReceivedLastWk, mydata.getsocialActionsReceivedLastWk());
		    	inst.setValue(socialActorsReceivedLastWk, mydata.getsocialActorsReceivedLastWk());
		    	inst.setValue(socialActionsSentLastWk, mydata.getsocialActionsSentLastWk());
		    	inst.setValue(socialActorsSentLastWk, mydata.getsocialActorsSentLastWk());
		    	inst.setValue(daysSinceLastSend, mydata.getdaysSinceLastSend());
		    	inst.setValue(daysSinceLastReceive, mydata.getdaysSinceLastReceive());
		    	System.out.println("The instance: " + inst);
		    	System.out.println("=====");
		    	
		    	data.add(inst);
		    	try {
					result = MyClassifier.classifyInstance(data.instance(0));
					System.out.println("result is: " + result);
					model.put("result", result);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    	response.type("application/json");
				return new MyMessage(""+result);
		    }
        });
		
//		get(new JsonTransformerRoute("/result") {
//			@Override
//			public Object handle(Request request, Response response) {
//				response.type("application/json");
//				return new MyMessage(Double.toString(result));
//			}
//			
//		});
	}
}