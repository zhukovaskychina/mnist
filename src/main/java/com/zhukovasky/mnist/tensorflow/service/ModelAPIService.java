package com.zhukovasky.mnist.tensorflow.service;

import java.io.File;

import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.graphmapper.tf.TFGraphMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhukovasky.mnist.config.ModelConfig;

@Service
public class ModelAPIService {
	
	@Autowired
	private ModelConfig modelConfig;
	
	
	
	private SameDiff regressionAPI;
	
	private SameDiff convolutionalAPI;
	
	public SameDiff loadRegressionAPI() {
		if(this.regressionAPI==null) {
			this.regressionAPI= TFGraphMapper.getInstance().importGraph(new File(modelConfig.getModelRegressionPath()));
		}
	    
		return this.regressionAPI;
	}
	
	public SameDiff loadConvolutionalAPI() {
		if(this.convolutionalAPI==null) {
			this.convolutionalAPI= TFGraphMapper.getInstance().importGraph(new File(modelConfig.getModelConvolutionalPath()));
		}
		return this.convolutionalAPI;
	}
}
