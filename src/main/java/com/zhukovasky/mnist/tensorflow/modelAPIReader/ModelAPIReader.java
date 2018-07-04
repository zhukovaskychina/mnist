package com.zhukovasky.mnist.tensorflow.modelAPIReader;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.io.ClassPathResource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import com.zhukovasky.mnist.config.ModelConfig;
@Component
public class ModelAPIReader {
	
	@Autowired
	private ModelConfig modelConfig;
	
	public Map<String,INDArray> readPlaceHodersAndPredictions(){
        Map<String, INDArray> arraysFromPython = new HashMap<>();
        return arraysFromPython;
	}
	
	public INDArray generateINDArray() throws IOException {
		final String MLP=new ClassPathResource(modelConfig.getModelPath()).getFile().getPath();
		
		//加载placeholder输入以及相关预测系数 
		Map<String,INDArray> inputsPredictions=readPlaceHodersAndPredictions();
		
		
		
		return null;
		
	}
	
	
}
