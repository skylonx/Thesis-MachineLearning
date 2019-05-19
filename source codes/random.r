# @author Shaela Khan 
# 29th April,2018
##
## Using Decision tree , random forest , boosting , Naive Bayes Model 
#

#load required libraries
library(readr,dplyr)
library(ggplot2)
library(corrplot)
library(gridExtra)
library(pROC)
library(MASS)
library(rpart)
library(rpart.plot) #prp()
library(klaR) # For NaiveBayes Model

install.packages("caret")
library(caTools)
## cart model
library("rpart")
library(rattle)


#load data
data <- read.csv("ChemoT2.csv")
#str(data)

library(caret)
data$VITAL_STATUS <- as.factor(data$VITAL_STATUS)
data[,16380] <- NULL



##find summary of the dataset 
#summary(data)
prop.table(table(data$VITAL_STATUS))



# a training and a testing set to use when building some models:
set.seed(1234)
data_index <- createDataPartition(data$VITAL_STATUS, p=0.7, list = FALSE)
train_data <- data[data_index, -1]
test_data <- data[-data_index, -1]

# Applying learning models
fitControl <- trainControl(method="repeatedcv",
                           number = 5,
                           preProcOptions = list(thresh = 0.99), # threshold for pca preprocess
                           classProbs = TRUE,
                           summaryFunction = multiClassSummary)


## Random Forest
#model_rf <- train(VITAL_STATUS~.,
#                  train_data,
#                  method="ranger",
#                  metric="ROC",
#                  #tuneLength=10,
#                  #tuneGrid = expand.grid(mtry = c(2, 3, 6)),
#                  preProcess = c('center', 'scale'),
#                  trControl=fitControl)

#set.seed(3233)
## testing for random forests
#pred_rf <- predict(model_rf, test_data)
#cm_rf <- confusionMatrix(pred_rf, test_data$VITAL_STATUS, positive = "M")
#cm_rf
##----------------------------------------------------------------------------------------------------------------------------##

#Model 2
#Naive Bayes Model
#Building and testing the model

#model_nb <- train(VITAL_STATUS~.,
#                  train_data,
#                  method="nb",
#                  metric="ROC",
#                  preProcess=c('center', 'scale'),
#                  trace=FALSE,
#                  trControl=fitControl)

## predicting for test data
#pred_nb <- predict(model_nb, test_data)
#cm_nb <- confusionMatrix(pred_nb, test_data$VITAL_STATUS, positive = "M")
#cm_nb
# To graph the tree
#prp(pred_nb$finalModel, box.palette = "Reds", tweak = 1.2)

##----------------------------------------------------------------------------------------------------------------------------------##
## Model 3 -> Boosting 
library(gbm)
library(plyr)


set.seed(1)
#gbm_model <- train(VITAL_STATUS ~ ., train_data, method="gbm", verbose=FALSE)
#gbm_model

gbm_model$finalModel
#Performance on testing set:

pred5 <- predict(gbm_model, test_data)
confusionMatrix(pred5, test_data$diagnosis, positive="M")






















