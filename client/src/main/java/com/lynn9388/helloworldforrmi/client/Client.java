/*
 * Copyright (C) 2016 Lynn
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.lynn9388.helloworldforrmi.client;

import com.lynn9388.helloworldforrmi.rmi.HelloWorld;

import java.io.IOException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static String serverIp = "localhost";
    private static int serverPort = 1099;

    public static void sayHello(HelloWorld helloWorld, String message) {
        try {
            System.out.println("Send message:" + message);
            System.out.println("Message received:" + helloWorld.sayHello(message));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
            HelloWorld helloWorld = (HelloWorld) registry.lookup(HelloWorld.NAME);
            System.out.println("Bound success!");
            sayHello(helloWorld, "Hello!");
            System.in.read();
        } catch (NotBoundException e) {
            System.err.println("Bound failed!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
