package com.zhukovasky.mnist.tensorflow.rest;

import java.io.File;

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
@RequestMapping("/mnistRest")
@Api(description = "Mnist数据传输")
public class MnistRest {

	@Autowired
	private RecognizeService recognizeService;
	
	@PostMapping(value="/api/mnist")
    @ApiOperation(value = "上传Mnist数据信息，用于返回概率数组", notes = "通过主键ID删除单条任务数据,返回是否成功标志")
	public ReturnJson<INDArray> recognizeInputs(@RequestBody(required = true) int[] inputImagePoints) {
		INDArray indArray=this.recognizeService.wiredInputArrays(inputImagePoints);
	    INDArray predictions=this.recognizeService.recognizeMnistRegression(indArray);
		return ReturnJson.success(predictions);
	}
}
