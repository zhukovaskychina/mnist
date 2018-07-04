package com.zhukovasky.mnist.tensorflow.service;

import java.io.File;

import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.graphmapper.tf.TFGraphMapper;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhukovasky.mnist.config.ModelConfig;

@Service
public class RecognizeService {

	
	@Autowired
	private ModelAPIService modelAPIService;
	

	
	public INDArray recognizeMnistRegression(INDArray input) {
	    SameDiff graphSD = this.modelAPIService.loadRegressionAPI();
		graphSD.associateArrayWithVariable(input, graphSD.variableMap().get("input"));
		INDArray predictionArray=graphSD.execAndEndResult();
		return predictionArray;
	}
	
	public INDArray recognizeMnistConvolutional(INDArray input) {
	    SameDiff graphSD = this.modelAPIService.loadConvolutionalAPI();
		graphSD.associateArrayWithVariable(input, graphSD.variableMap().get("input"));
		INDArray predictionArray=graphSD.execAndEndResult();
		return predictionArray;
	}
	public INDArray wiredInputArrays( int[] inputImagePoints) {
		INDArray ind=Nd4j.create(inputImagePoints);
		//(255-np.array(inputImagePoints))
		//根据计算公式生成如下操作
		ind.muli(-1).addi(255).muli(1/255).reshape(1,784);
		return ind;
	}
}
