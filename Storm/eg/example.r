#!/usr/local/bin/r -i

#when installed
#library(Storm)

#for now
source("Storm/R/Storm.R");

#create a Storm object
storm = Storm$new();
#by default it has a handler that logs that the tuple was skipped.
#let's replace it that with something more useful:
storm$lambda = function(s) {
  #argument 's' is the Storm object.

  #get the current Tuple object.
  t = s$tuple;

  #optional: acknowledge receipt of the tuple.
  s$ack(t);

  #optional: log a message.
  s$log(c("processing tuple=",t$id));

  #create contrived tuples to illustrate output.

  #create 1st tuple...
  t$output = vector(mode="character",length=1);
  t$output[1] = as.numeric(t$input[3])+as.numeric(t$input[4]);
  #...and emit it.
  s$emit(t);

  #create 2nd tuple...
  t$output[1] = as.numeric(t$input[3])-as.numeric(t$input[4]);
  #...and emit it.
  s$emit(t);

  #alternative/optional: mark the tuple as failed.
  s$fail(t);
};

#enter the main tuple-processing loop.
storm$run();
