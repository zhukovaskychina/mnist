package com.zhukovasky.mnist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****
 * 模型加载配置，用于加载读取训练完成后的model
 * */
@Component
@ConfigurationProperties(prefix="tensorflow.model")
public class ModelConfig {
	
	
	private String modelConvolutionalPath;


	private String modelRegressionPath;


	public String getModelConvolutionalPath() {
		return modelConvolutionalPath;
	}


	public void setModelConvolutionalPath(String modelConvolutionalPath) {
		this.modelConvolutionalPath = modelConvolutionalPath;
	}


	public String getModelRegressionPath() {
		return modelRegressionPath;
	}


	public void setModelRegressionPath(String modelRegressionPath) {
		this.modelRegressionPath = modelRegressionPath;
	}
	
	
	
}
