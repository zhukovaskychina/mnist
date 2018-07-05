package com.zhukovasky.mnist.tensorflow.rest;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.graphmapper.tf.TFGraphMapper;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhukovasky.mnist.config.ModelConfig;
import com.zhukovasky.mnist.tensorflow.service.RecognizeService;
import com.zhukovasky.mnist.tensorflow.util.ReturnJson;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mnist")
@Api(description = "Mnist数据传输")
public class MnistRest {

	@Autowired
	private RecognizeService recognizeService;
	
	@PostMapping(value="/api/mnist")
    @ApiOperation(value = "上传Mnist数据信息，用于返回概率数组", notes = "根据返回的数据实现数组的标记")
	public ReturnJson recognizeInputs(@Valid @RequestBody(required = true) double[] inputImagePoints) {
		INDArray indArray=this.recognizeService.wiredInputArrays(inputImagePoints);
	    INDArray predictionsRegression=this.recognizeService.recognizeMnistRegression(indArray);
	    INDArray predictionsConvolution=this.recognizeService.recognizeMnistConvolutional(indArray);
		Map<String,double[]> resultMap=new HashMap<String,double[]>();

		resultMap.put("output1", predictionsRegression.toDoubleVector());
		resultMap.put("output2", predictionsConvolution.toDoubleVector());

	    return ReturnJson.success(resultMap); 
	}
}
