package com.github.allenday;

import org.junit.Test;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.generated.StormTopology;

public class TestPermute {


	@Test
	public void test() {
		StormTopology topology = PermuteTopology.create();

	    Config conf = new Config();
	    conf.setDebug(true);

//	    if (args != null && args.length > 0) {
//	      conf.setNumWorkers(3);
//	      StormSubmitter.submitTopology(args[0], conf, builder.createTopology());
//	    }
//	    else {
	    
	      conf.setMaxTaskParallelism(3);

	      LocalCluster cluster = new LocalCluster();
	      cluster.submitTopology("TestPermute", conf, topology);

	      try {
			Thread.sleep(10000);
	      } catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	      }

	      cluster.shutdown();
//	    }
	}

	
/*	
	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{ new Integer[]{2005, 2010}, new Double[]{5.683, 2.158} }, 
				{ new Integer[]{2006, 2007, 2008, 2009}, new Double[]{4.978, 4.273, 3.568, 2.863 } } });
	}

	Integer[] inputs;
	Double[] expected;

	public TestPermute(Integer[] inputs, Double[] expected){
		this.inputs = inputs;
		this.expected = expected;
	}

	private String[] getNames(int count){
		String[] names = new String[count];
		for(int i = 0; i < count; i++){
			names[i] = "val" + i;
		}
		return names;
	}
*/
}
