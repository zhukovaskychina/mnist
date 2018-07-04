package com.zhukovasky.mnist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/****
 * 模型加载配置，用于加载读取训练完成后的model
 * */
@Component
@ConfigurationProperties(prefix="tensorflow.model")
public class ModelConfig {
	
	
	private String modelPath;

	public String getModelPath() {
		return modelPath;
	}

	public void setModelPath(String modelPath) {
		this.modelPath = modelPath;
	}
	
	
}
