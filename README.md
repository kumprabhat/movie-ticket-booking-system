<h1 align="center"> movie-ticket-booking-system</h1>
<h3 align="center">Online movie ticket booking platform</h3>

# Table of contents

- [1.Problem Statement](#1problem-statement)
- [2.Overview of requirements](#2overview-of-requirements)
  - [2.1 Summary of functional requirements](#21-Summary-of-functional-requirements)
  - [2.2 Summary of non-functional requirements](#22-Summary-of-non-functional-requirements)
- [3.Overview of Solution Architecture](#3overview-of-Solution-Architecture)
  - [3.1 Application Architecture](#31-application-architecture)
  - [3.2 Design Objectives and Principles](#32-desing_objective_principle)
  - [3.3 Design Considerations](#33-design_consideration)
  - [3.4 Technology Stack](#34-technology_stack)
- [4.Deployment Architecture](#4deployment_architecture)
- [5.Installation Experience](#5installation_experience)
  - [5.1 Continous Integration and Continous Deployment](#51-constinour_integration_continous_deployment)

# 1.Problem Statement

We have to build an online movie ticket booking platform that caters to both **B2B**(Theatre Partners) and **B2C**(End Customers) clients. Key goals we want to accomplish as part of the solution :

- Enable theatre partners to onboard their theatres over this platform and get access to a bigger customer base while going digital.
- Enable End Customers to browse thw platform to get access to movies across different cities, languages, and genres, as well as book tickets in advance with a seamless experience.

# 2.Overview of requirements

## 2.1 Summary of functional requirements

 <p align="center">
        <img src="/img/sytstemcontextdiagram.png" alt= "Movie Ticket Booking System">
        <br />
        Movie Ticket Booking System - System Context Diagram
        <br />
        <br />
        <img src="/img/usecasediagram.png" alt= "Movie Ticket Booking System UseCase">
        <br />
         Movie Ticket Booking System - Use Case Model Diagram
        <br />
 </p>
 
 #### Use Case Overview

| User Case ID | Use Case Name                          | Descriptions                                                                                                                                                                                                                                           |
| ------------ | -------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| UC-01        | Search Movie                           | Allows B2C and B2B end Users to search Movie by language, City, release date and Title                                                                                                                                                                 |
| UC-02        | Create Booking                         | Allows B2C end user to book movie ticket by selectiing theatre,timing and preferred seats for the day and will make third party payment integration. This will also send SMS and Email notification to both B2B and B2C user after successful bookings |
| UC-03        | View Booking                           | Allows B2C user to view the booking                                                                                                                                                                                                                    |
| UC-04        | Cancel Booking                         | Allows B2C user to cancel the booking and will initiate the refund payment after seat/s release. This will also send SMS/Email notification to both B2B and B2C users after successful cancelation/s                                                   |
| UC-05        | CRUD of Movie                          | Allows B2B(Internal operator) to create, update, and delete Movie                                                                                                                                                                                      |
| UC-06        | CRUD of Show                           | Allows B2B(Internal operator) to create, update, and delete Show                                                                                                                                                                                       |
| UC-07        | CRUD of Cinema                         | Allows B2B(Internal operator) to create, update, and delete Cinema                                                                                                                                                                                     |
| UC-08        | CRUD of City                           | Allows B2B(Internal operator) to create, update, and delete City                                                                                                                                                                                       |
| UC-09        | Compaign Manager                       | Enables the configuration of offers and deals for both oure internal business team and theatre operator                                                                                                                                                |
| UC-10        | Bulk Cancellation                      | Bulk booking cancellation for B2B users                                                                                                                                                                                                                |
| UC-11        | Bulk Booking                           | Bulk Booking for B2B users                                                                                                                                                                                                                             |
| UC-12        | Send Booking Notification              | System will send SMS and Email notification to B2C and B2B users after successful/Cancellation Booking                                                                                                                                                 |
| UC-13        | New Movie Suggestions                  | System will suggest for new movie based on history data                                                                                                                                                                                                |
| UC-14        | Pull Data From External Theatre system | System will connect with the external theatre lmanagement system to pull external inventory as there may be some thetres that are not part of our local Theatre management system                                                                      |

## 2.2 Summary of non-functional requirements

#### NFR Summary

| ID  | Requirement statement                                                                        |
| --- | -------------------------------------------------------------------------------------------- |
| 01  | The system should be highly scalable, available, reliable,consistent and fault tolerant      |
| 02  | Integrate with theatres having existing IT systems and new theatres and localization(movies) |
| 03  | Scale to multiple cities, countries and gurantee platform availability of 99.9%              |
| 04  | Movie Metadata - description, actor's info etc.                                              |
| 05  | Personalization - user history based suggestions                                             |
| 06  | Log Management - to debug application errors                                                 |
| 07  | Monitoring System - errors,alerts, request count, Visulatisation tools etc                   |
| 08  | Business Intelligence - near real-time analytics,dashboards, etc                             |
| 09  | Monetize the platform                                                                        |

# 3.Overview of Solution Architecture

## 3.1 Application Architecture

 <p align="center">
        <img src="/img/ApplicationArchitecture.png" alt= "Movie arch Booking System">
        <br />
        Movie Ticket Booking System - Application Architecture
 </p>

### Experience Layer Microservices

| Microservice Name      | Service Function                                                                                                           |
| ---------------------- | -------------------------------------------------------------------------------------------------------------------------- |
| b2b_tms_searchapi      | Platform provides this public api for internal theatre management system which will in turn call search domain service     |
| b2c_tms_searchapi      | Platform provides this public api for Ticket Booking system which will in turn call search domain service                  |
| b2c_tbs_booking_api    | Platform provides this public api for Ticket Booking system which will in turn call booking domain service                 |
| b2b_inventory_mngr_api | Platform provides this public api for internal theatre management system will in turn call internal manager domain service |

### Domain Microservices

| Microservice Name             | Service Function                                                                                                                                                                                                                                          |
| ----------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| search_svc                    | It is primary interface that allows users to search for movies. Retrieves data from elastic search and customization such as fiters, ongoing deals/compaign etc.                                                                                          |
| tbs_booking_svc               | it is core domain service to manage the entire booking process. This will fetch seats info, reserving seats, initiate payment, confirming booking after successful payment and initiating the ticketing workflow.                                         |
| tbs_ticket_svc                | This service manages all operation related to the ticketing workflow including workflows such as billing, notificatons and invoice for both booking and cancellation events.                                                                              |
| billing_svc                   | This will record the credit and debit of various components, such as fare, commission and offers and more between organization, theatre operators and the end users.                                                                                      |
| notification_svc              | It manages all the different types of notifications triggered by the system.                                                                                                                                                                              |
| b2b_inventory_mngr_svc        | This will enable B2B opearators to manage their inventory. This includes configuring theatres, halls, shows, fares, seats layouts, offers etc                                                                                                             |
| inventory_aggrgator_svc       | This service is responsible to combine the data from both local and remote theatre, transform the data to system compatible format if necessary and return the result to caller.                                                                          |
| payment_manager_svc           | It is responsible for all the payment related workflows and interfacing with the available payment gateways                                                                                                                                               |
| inventory_freshness_svc       | It updates the elasticsearch with any changes made to the inventory by the theatre operators. This ensures that our search data is always up-to date.                                                                                                     |
| scheduled_search_data_builder | It is crawler that runs periodically aggreagating all the available inventory for predefined number of days and copies to elasticsearch.It pulls inventory from both our internal theatre system and external theatre system integrated with our platform |

## 3.2 Design Objectives and Principles

1.  Increase cohesion where possible
2.  Reduce coupling where possible
3.  Keep the level of abstraction as high as possible
4.  Increase reusablility where possible
5.  Design for flexibility
6.  Design should not reinvent the wheel
7.  Design for portability

## 3.3 Design Considerations

1. Object orientation
2. Microservice based architecture pattern such as chain proxy pattern, SAGA pattern, CQRS, API Gateway pattern, Change data capture patten and more.
3. Loose coupling
4. Modularity
5. scalability
6. avaiablility
7. separate reporting Layer
8. Audit Trail, Logging and Monitoring

## 3.4 Technology Stack

     Spring Boot
     MySql
     keycloak
     open JDK
     elastic search
     EFK Stack
     kafka
     openshift
     prometheus and Nagios
     selenium ,robot, cucumber
     kubernetes
     Docker/podman
     Redis

# 4.Deployment Architecture

 <p align="center">
        <img src="/img/deploymentarch.png" alt= "Movie deployarch Booking System">
        <br />
        Movie Ticket Booking System - Deployment Architecture
 </p>

# 5.Installation Experience

### 5.1 Continous Integration and Continous Deployment

   <p align="center">
        <img src="/img/api_msa_ci_cd.png.png" alt= "Movie cicd Booking System">
        <br />
        Movie Ticket Booking System - CI/CD pipeline
 </p>
     </br>
    <p align="center">
        <img src="/img/api_msa_ci_cd_msa.png" alt= "Movie cicdmsa Booking System">
        <br />
        Movie Ticket Booking System - CI/CD pipeline
 </p>
