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

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Middle {
    public static final int PORT = 1100;

    public static void main(String[] args) {
        try {
            HelloWorld stub = new HelloWorldImpl();

            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.rebind(HelloWorld.NAME, stub);
            System.out.println("Bound success!");
        } catch (RemoteException e) {
            System.err.print("Bound failed!");
            e.printStackTrace();
        }
    }
}
