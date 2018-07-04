package com.zhukovasky.mnist;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.deeplearning4j.datasets.iterator.impl.MnistDataSetIterator;
import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.Updater;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.conf.layers.OutputLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.nn.weights.WeightInit;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.lossfunctions.LossFunctions.LossFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/** * 本示例使用Deeplearning4j构建了一个多层感知器（MLP）来进行手写数字（MNIST）的识别 * 该示例中的神经网络只有1个隐藏层 * 
 * * 输入层的维度是numRows*numColumns（图像像素行数*图像像素列数），即每个手写数字图像的像素数量（28*28）
 *  * 隐藏层的大小为1000，使用RELU作为激活函数 * 输出层为SOFTMAX层，用于表示输入图像属于每个分类的概率（概率总和为1） * */
public class MLPMnistSingleLayerExample {    
        private static Logger log = LoggerFactory.getLogger(MLPMnistSingleLayerExample.class);    
        
        public static void main(String[] args) throws Exception {        
            //number of rows and columns in the input pictures           
        	final int numRows = 28;        
            final int numColumns = 28;        
            int outputNum = 10; // 手写字符类别的数量 
            int batchSize = 128; // batch大小，一个batch中的输入使用相同的神经网络参数          
            int rngSeed = 123; // 设置一个随机种子，使得每次跑程序获得的随机值相同           
            int numEpochs = 15; // 训练时每扫描一遍数据集算一个Epoch           
            //Deeplearning4j内置的MNIST数据集           
            DataSetIterator mnistTrain = new MnistDataSetIterator(batchSize, true, rngSeed);          
            DataSetIterator mnistTest = new MnistDataSetIterator(batchSize, false, rngSeed);           
            log.info("Build model....");            
            MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            		.seed(rngSeed) // 为模型设置随机种子          
            		.optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)// 使用随机梯度下降作为优化算法         
            		.iterations(1)                
            		.learningRate(0.006) // 设置学习速率                
            		.updater(Updater.NESTEROVS)                
            		.regularization(true).l2(1e-4) //设置L2正则系数，设置L2正则可以降低过拟合的程度               
            		.list() //开始构建MLP网络（多层感知器）                
            		.layer(0, new DenseLayer.Builder() //设置第一个Dense层                      
            		.nIn(numRows * numColumns) //输入为28*28                      
            		.nOut(1000) //输出为1000                        
            		.activation(Activation.RELU) //使用RELU激活    
            		.weightInit(WeightInit.XAVIER) //设置初始化方法                     
            		.build())                
            		.layer(1, new OutputLayer.Builder(LossFunction.NEGATIVELOGLIKELIHOOD) //设置第二个Dense层，OutputLayer也是Dense层  
            				.nIn(1000) //输入为1000                     
            				.nOut(outputNum) //输出为10，即手写数字的类别数量      
            				.activation(Activation.SOFTMAX) //使用SOFTMAX激活     
            				.weightInit(WeightInit.XAVIER)
            				.build())              
            		.pretrain(false).backprop(true) //进行反向传播，不进行预训练  
            		.build();            
            MultiLayerNetwork model = new MultiLayerNetwork(conf);            
            model.init();        //每隔1个iteration就输出一次score           
            model.setListeners(new ScoreIterationListener(1));           
            log.info("Train model....");
            for( int i=0; i<numEpochs; i++ ){             
            	model.fit(mnistTrain);            
            	}           
            log.info("Evaluate model....");         
            Evaluation eval = new Evaluation(outputNum); //创建一个评价器          
            while(mnistTest.hasNext()){               
            	DataSet next = mnistTest.next();              
            	INDArray output = model.output(next.getFeatureMatrix()); //模型的预测结果             
            	eval.eval(next.getLabels(), output); //根据真实的结果和模型的预测结果对模型进行评价       
            }            
            log.info(eval.stats());      
            log.info("****************Example finished********************");    
            } 
       
}