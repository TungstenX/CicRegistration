/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.pas.proof.cicregistration.controller;

/**
 *
 * @author andre
 */
public interface CicServiceinterface {
    boolean registerCic(String cicType, String subject, String body,
            String sourceSystem, String name, String email);
}
