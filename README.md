<h1 align="center"> movie-ticket-booking-system</h1>
<h3 align="center">Online movie ticket booking platform</h3>

# Table of contents

- [1.Problem Statement](#1problem-statement)
- [2.Overview of requirements](#2overview-of-requirements)
  - [2.1 Summary of functional requirements](#21-Summary-of-functional-requirements)
  - [2.2 Summary of non-functional requirements](#22-Summary-of-non-functional-requirements)
- [3.Overview of Solution Architecture](#3overview-of-Solution-Architecture)
  - [3.1 Application Architecture](#31-application-architecture)
- [4.Application Security Architecture](#4application-security-architecture)

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
