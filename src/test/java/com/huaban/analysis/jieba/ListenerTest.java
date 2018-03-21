package com.huaban.analysis.jieba;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@RunWith(JUnit4.class)
public class ListenerTest {

    JiebaSegmenter segmenter = new JiebaSegmenter();

    @Before
    public void setUp() throws IOException {
        segmenter.registerListener(System.out::println);
    }

    @Test
    public void test01() {
        segmenter.suggestFreq(true,"中", "将");
        List<String> strings = segmenter.sentenceProcess("如果放到post中将出错");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test02() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.suggestFreq(true, "君意");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test03() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.suggestFreq(true, "美", "容");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        strings = segmenter.sentenceProcess("美容");
        System.out.println(String.join("/", strings));
    }

    @Test
    public void test04() {
        List<String> strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        segmenter.delWord("美容美发");
        strings = segmenter.sentenceProcess("大连美容美发学校中君意是你值得信赖的选择");
        System.out.println(String.join("/", strings));
        strings = segmenter.sentenceProcess("美容");
        System.out.println(String.join("/", strings));
    }
}