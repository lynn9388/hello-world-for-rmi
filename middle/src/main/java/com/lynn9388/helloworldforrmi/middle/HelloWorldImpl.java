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

package com.lynn9388.helloworldforrmi.middle;

import com.lynn9388.helloworldforrmi.rmi.HelloWorld;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld {
    private static String serverIp = "localhost";
    private static int serverPort = 1099;

    protected HelloWorldImpl() throws RemoteException {
    }

    @Override
    public String sayHello(String message) throws RemoteException {
        System.out.println("Message received from client:" + message);

        String echo = null;
        Registry registry = LocateRegistry.getRegistry(serverIp, serverPort);
        try {
            HelloWorld helloWorld = (HelloWorld) registry.lookup(HelloWorld.NAME);
            echo = helloWorld.sayHello(message);
            System.out.println("Message received from server:" + echo);
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
        return echo;
    }
}
