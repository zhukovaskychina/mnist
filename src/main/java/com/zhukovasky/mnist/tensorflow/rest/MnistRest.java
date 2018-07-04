package com.zhukovasky.mnist.tensorflow.rest;

import java.io.File;

import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.graphmapper.tf.TFGraphMapper;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.cpu.nativecpu.NDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhukovasky.mnist.config.ModelConfig;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/mnistRest")
@Api(description = "Mnist数据传输")
public class MnistRest {
	
	@Autowired
	private ModelConfig modelConfig;
	
	@PostMapping(value="/api/mnist")
    @ApiOperation(value = "上传Mnist数据信息，用于返回概率数组", notes = "通过主键ID删除单条任务数据,返回是否成功标志")
	public void recognizeInputs(@RequestBody(required = true) int[] inputImagePoints) {
		INDArray ind=Nd4j.create(inputImagePoints);
		//(255-np.array(inputImagePoints))
		//根据计算公式生成如下操作
		INDArray normalArray=ind.muli(-1).addi(255);
		normalArray.muli(1/255).reshape(1,784);
	    SameDiff graphSD = TFGraphMapper.getInstance().importGraph(new File(modelConfig.getModelPath())); //导入模型
	    graphSD.associateArrayWithVariable(normalArray, graphSD.variableMap().get("input"));
	    
	    INDArray sameDiffPred=graphSD.execAndEndResult();
	    
	    
	}
}
