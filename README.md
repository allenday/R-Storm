# Write Storm Bolts in R using the Storm Multi-Language Protocol 

*R Support for Apache Storm Multilang Protocol*

## Description

Storm is a distributed realtime computation system. Similar to how Hadoop provides a set of general primitives for doing batch processing, Storm provides a set of general primitives for doing realtime computation.

Storm includes a “Multi-Language” (or “Multilang”) Protocol to allow implementation of Bolts and Spouts in languages other than Java. This R extension provides implementations of utility functions to allow an application developer to focus on application-specific functionality rather than Storm/R communications plumbing.

## Details

From Storm’s point of view, it creates an R process to consume and produce Tuples. Storm commu- nicates with R using a JSON-like format. Storm writes Tuples via STDIN, and reads Tuples from R via STDOUT. The Storm package implements several functions to take care of Storm/R I/O.

As the application programmer, you implement a single function with signature:v “function(s=Storm, t=Tuple)” that will be called once per Tuple. Inside this function, you can emit zero or more Tuples, as well as emit other status messages, such as failures and diagnostic messages.

To use this extension, briefly:

1. create a new Storm object.
2. define a function that can process and emit Tuple objects.
3. call the run() method on the Storm object.

A detailed example is given in the examples section.

## Git Repository Structure

You'll find two directories here:

* java/  - contains a maven project for testing R with a very simple string permutation test.  Run it as 'mvn test'.  You'll need to have the "Storm" and "permute" R packages installed.
* Storm/ - contains the R Storm package itself.  To use it, you'll either want to install from CRAN (e.g. 'install.packages("Storm")'), or by 'R CMD install Storm'.

## See Also
[https://github.com/nathanmarz/storm/wiki/Using-non-JVM-languages-with-Storm](https://github.com/nathanmarz/storm/wiki/Using-non-JVM-languages-with-Storm)
[https://github.com/nathanmarz/storm/wiki/Multilang-protocol](https://github.com/nathanmarz/storm/wiki/Multilang-protocol)

