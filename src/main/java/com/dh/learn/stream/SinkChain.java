package com.dh.learn.stream;

import java.util.Arrays;
import java.util.Spliterator;
import java.util.function.Consumer;
public class SinkChain {
	public static void main(String[] args) {
		int[] source = {1,2,3,4,5};
		Spliterator<Integer> spliterator = Arrays.stream(source).spliterator();
		
		//setup upstream
		Sink<Integer> sink0 = new Sink<Integer>("source sink", null);
		Sink<Integer> sink4 = sink0.op("sink1").op("sink2").op("sink3").op("terminal sink");
		
		//setup downstream chain
		Sink<Integer> wrappedSink = wrapSink(sink4);	
		assert(wrappedSink == sink0); //now get the first (source) stage
		
		//in one loop, handle elements: 1,2,3,4,5
		spliterator.forEachRemaining(wrappedSink);
	}
	public static Sink<Integer> wrapSink(Sink<Integer> sink) {
		while(sink.upstream != null) {
			sink.upstream.downstream = sink;
			sink = sink.upstream;
		}
		
		return sink;
	}
	
	static class Sink<T> implements Consumer<T>{
		private Sink<T> upstream; 
		private Sink<T> downstream;
		private String name;
		
		public Sink(String name, Sink<T> upstream) {
			this.name = name;
			this.upstream = upstream;
		}
		
		public Sink<T> op(String name) {
			return new Sink<T>(name, this);
		}
		
		@Override
		public void accept(T t) {
			System.out.println(name + " handles " + t);
			if (downstream != null)
				downstream.accept(t);
		}
	}
}