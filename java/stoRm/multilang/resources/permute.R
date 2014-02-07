#!/usr/bin/Rscript
library(permute,quietly=TRUE)
library(Storm,quietly=TRUE)

storm = Storm$new();

storm$lambda = function(s) {
  t = s$tuple;
  s$ack(t);
  #s$log(c("processing tuple=",t$id));

  words = strsplit(t$input[1],"\\s+",perl=TRUE)[[1]];

  t$output = vector(mode="character",length=1);
  t$output[1] = paste(c("PERMUTE",words[shuffle(length(words))]),collapse=" ");
  s$emit(t);

  #alternative/optional: mark the tuple as failed.
  #s$fail(t);
};

storm$run();
