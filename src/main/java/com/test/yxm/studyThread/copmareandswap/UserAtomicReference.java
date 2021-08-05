package com.test.yxm.studyThread.copmareandswap;

import java.util.concurrent.atomic.AtomicReference;

public class UserAtomicReference {
    static AtomicReference<UserInfo> atomicReference;

    public static void main(String[] args) {
        UserInfo user = new UserInfo("Mark",15);
        atomicReference = new AtomicReference<>(user);
        UserInfo updateUser = new UserInfo("Bill",17);
        atomicReference.compareAndSet(user,updateUser);
        System.out.println(atomicReference.get());
        System.out.println(user);
    }

    static class UserInfo{
        private String name;
        private int age;
        public UserInfo(String name ,int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
