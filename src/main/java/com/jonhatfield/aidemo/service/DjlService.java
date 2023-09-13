package com.jonhatfield.aidemo.service;

import ai.djl.Model;
import ai.djl.basicdataset.cv.classification.Mnist;
import ai.djl.ndarray.types.Shape;
import ai.djl.nn.Activation;
import ai.djl.nn.Blocks;
import ai.djl.nn.SequentialBlock;
import ai.djl.nn.core.Linear;
import ai.djl.training.DefaultTrainingConfig;
import ai.djl.training.EasyTrain;
import ai.djl.training.Trainer;
import ai.djl.training.TrainingResult;
import ai.djl.training.dataset.Dataset;
import ai.djl.training.evaluator.Accuracy;
import ai.djl.training.listener.TrainingListener;
import ai.djl.training.loss.Loss;
import com.fasterxml.jackson.databind.JsonNode;
import com.jonhatfield.aidemo.dto.DjlImageClassificationResponse;
import com.jonhatfield.aidemo.dto.OpenNlpPosResponse;
import lombok.extern.slf4j.Slf4j;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class DjlService {

    public DjlImageClassificationResponse classifyImage(String message) {
        try {
            Model mlpModel = Model.newInstance("mlp");

            //prepare data - load dataset
            int batchSize = 32;
            Mnist trainingDataset = Mnist.builder()
                    .optUsage(Dataset.Usage.TRAIN)
                    .setSampling(batchSize, true)
                    .build();

            //build neural network
            long inputSize = Mnist.IMAGE_HEIGHT * Mnist.IMAGE_WIDTH;
            long outputSize = 10;
            SequentialBlock block = new SequentialBlock();
            block.add(Blocks.batchFlattenBlock(inputSize));
            block.add(Linear.builder().setUnits(128).build());
            block.add(Activation::relu);
            block.add(Linear.builder().setUnits(64).build());
            block.add(Activation::relu);
            block.add(Linear.builder().setUnits(outputSize).build());

            mlpModel.setBlock(block);

            DefaultTrainingConfig config = new DefaultTrainingConfig(Loss.softmaxCrossEntropyLoss())
                    .addEvaluator(new Accuracy())
                    .addTrainingListeners(TrainingListener.Defaults.logging());

            Trainer trainer = mlpModel.newTrainer(config);

            int trainingParamsInitializationBatchSize = 1;
            trainer.initialize(new Shape(trainingParamsInitializationBatchSize, inputSize));
            int epochs = 2;
            EasyTrain.fit(trainer, epochs, trainingDataset, null);//TODO null
            //can now save model - if need to
            TrainingResult trainingResult = trainer.getTrainingResult();


            return null;
        } catch (Exception e) {
            log.error("Image classification error", e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public JsonNode getExampleInputImages() {
        return null;
    }
}