package io.mosip.testrig.apirig.data.mapping;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;;


public class JsonPathGenMain {
	static JsonPathGenMain obj = new JsonPathGenMain();
	String parentpath="";
	public static void main(String arg[]) throws IOException
	{
		//String inputFilePath="D:\\MosipTestJavaWokspace\\IDAAutomation\\Resources\\masterdataIDA.json";
		String inputFilePath="D:\\MOSIP\\test_DEV\\v4\\mosip-test\\automation\\mosip-qa\\src\\test\\resources\\preReg\\TestData\\Create_PreRegistration\\input\\request.json";
		//obj.generateJSONPath(new String(Files.readAllBytes(Paths.get(inputFilePath))));
		JsonPathGen o = new JsonPathGen(new String(Files.readAllBytes(Paths.get(inputFilePath))));
		o.generateJsonMappingDic("D:\\MOSIP\\test_DEV\\v4\\mosip-test\\automation\\mosip-qa\\src\\test\\resources\\preReg\\TestData\\Create_PreRegistration\\input\\PreRegValidRequest.properties");
		//logger.info(o.getPathList());
	}
}
