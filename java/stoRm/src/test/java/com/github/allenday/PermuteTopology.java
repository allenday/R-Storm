package com.github.allenday;

import java.util.Map;

import storm.starter.spout.RandomSentenceSpout;
import backtype.storm.generated.StormTopology;
import backtype.storm.task.ShellBolt;
import backtype.storm.testing.IdentityBolt;
import backtype.storm.topology.IRichBolt;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.tuple.Fields;

public class PermuteTopology {
	TopologyBuilder builder = null;
	public static class PermuteBolt extends ShellBolt implements IRichBolt {
		private static final long serialVersionUID = 4305587293613439941L;

		public PermuteBolt() {
			//Note: this relies on installed software:
			//* R (with 'Rscript' in $PATH)
			//* R "stoRm" library
			//* R "permute" library
			super("Rscript", "permute.R");
			//super("/usr/bin/python", "/Users/mapr/src/storm/storm-core/src/dev/resources/tester_bolt.py");
		}

		@Override
		public void declareOutputFields(OutputFieldsDeclarer declarer) {
			declarer.declare(new Fields("permutation"));
		}

		public Map<String, Object> getComponentConfiguration() {
			return null;
		}

	}

	public static StormTopology create() {
	    TopologyBuilder builder = new TopologyBuilder();
	    builder.setSpout("spout", new RandomSentenceSpout(), 1);

	    builder.setBolt("permutebolt", new PermuteBolt(), 1).shuffleGrouping("spout");
	    //builder.setBolt("count", new IdentityBolt(new Fields("identity")), 1).fieldsGrouping("permutebolt", new Fields("permutation"));
		return builder.createTopology();

	}	
}
