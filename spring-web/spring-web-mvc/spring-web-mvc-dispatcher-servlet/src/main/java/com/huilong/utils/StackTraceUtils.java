/*
 * **********************************************************************
 * Copyright (c) 2021 .
 * All rights reserved.
 * 项目名称：spring-web-mvc-dispatcher-servlet Maven Webapp
 * 版权说明：原创不易，传播请注明出处
 * ***********************************************************************
 */
package com.huilong.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author daocr
 * @date 2021/2/2
 */
@Slf4j
public class StackTraceUtils {

    private StackTraceUtils() {
    }



    @SneakyThrows
    public static void serializeStackTrace(String filePath) {

        File file = new File(filePath);

        if (file.exists()) {
            log.info("序列化文件已存在");
            return;
        }

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(file, stackTrace);

        log.info("序列化到 {} ", file.getAbsolutePath());
    }


    public static void main(String[] args) throws IOException {


        List<String> exclude = Arrays.asList("tomcat");

        // 1、加装文件
        List<List<StackTraceElement>> allStack = loadFile();

        Node root = null;

        for (List<StackTraceElement> traceElements : allStack) {

            for (int i = 0; i < traceElements.size(); i++) {

                StackTraceElement traceElement = traceElements.get(i);
                StackTraceElement traceParentElement = traceElements.get(i == 0 ? 0 : i - 1);


                ThreadLocalRandom current = ThreadLocalRandom
                        .current();
                Node node = new Node();
                node.setId(traceElement.getMethodName() +current.nextInt(1,10000000) );
                node.setData(traceElement);

                // xx
                if (root == null) {
                    root = node;
                    continue;
                }

                // 如果传入节点等于根节点，可以直接跳过
                if (root.data.equals(traceElement)) {
                    continue;
                }

                Node findNode = find(root, traceParentElement);

                if (Objects.isNull(findNode)) {
                    throw new RuntimeException("查询错误");
                }

                // xxx
                List<Node> child = findNode.getChildren();

                if (child == null) {
                    child = new ArrayList<>();
                    findNode.setChildren(child);
                    child.add(node);
                    continue;
                }

                //xxx
                Optional<Node> exist = child.stream().filter(c -> {
                    StackTraceElement data = c.getData();
                    return data.equals(traceElement);
                }).findFirst();

                // xxx
                if (exist.isEmpty()) {
                    child.add(node);
                }
            }
        }


        ObjectMapper objectMapper = new ObjectMapper();
        String rootString = objectMapper.writeValueAsString(root);

        System.out.println(rootString);

    }

    private static Node find(Node node, StackTraceElement traceElement) {

        if (node.data.equals(traceElement)) {
            return node;
        }

        if (node.children == null) {
            return null;
        }

        for (Node ch : node.children) {
            Node findValue = find(ch, traceElement);

            if (!Objects.isNull(findValue)) {
                return findValue;
            }
        }

        return null;
    }

    /**
     * 加载 文件
     *
     * @return
     * @throws IOException
     */
    private static List<List<StackTraceElement>> loadFile() throws IOException {

        File dirFile = new File("/Users/daocr/IdeaProjects/study/Spring-Framework-Study/spring-web/spring-web-mvc/spring-web-mvc-dispatcher-servlet/src/main/resources/stack/");

        File[] files = dirFile.listFiles();

        ArrayList<List<StackTraceElement>> allStack = new ArrayList<>();

        for (File file : files) {
            ObjectMapper objectMapper = new ObjectMapper();
            StackTraceElement[] insertStackTraceElement = objectMapper.readValue(file, new StackTraceElement[1].getClass());

            List<StackTraceElement> stackTraceElements = Arrays.asList(insertStackTraceElement);
            Collections.reverse(stackTraceElements);
            allStack.add(stackTraceElements);
            log.info("加载文件：{}", file.getName());
        }

        return allStack;
    }


    public static class AntvG6 {


    }


    /**
     *
     */
    @Data
    public static class Node {

        private StackTraceElement data;

        private String id;


        private List<Node> children;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node ext = (Node) o;
            return Objects.equals(data, ext.data);
        }


        @Override
        public String toString() {
            return data.toString();
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

}

