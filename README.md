<h1 align="center"> movie-ticket-booking-system</h1>
<h3 align="center">Online movie ticket booking platform</h3>

# Table of contents

- [1.Problem Statement](#1problem-statement)
- [2.Overview of requirements](#2overview-of-requirements)
  - [2.1 Summary of functional requirements](#21-Summary-of-functional-requirements)
  - [2.2 Summary of non-functional requirements](#22-Summary-of-non-functional-requirements)
  - [2.4 Python package statistics](#24-python-package-statistics)
  - [2.5 Fast information of repository](#25-fast-information-of-repository)
  - [2.6 Github dynamic badges](#26-github-dynamic-badges)

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

| User Case ID | Use Case Name  | Descriptions                                                                                                                                                                                                                                           |
| ------------ | -------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------ |
| UC-01        | Search Movie   | Allows B2C and B2B end Users to search Movie by language, City, release date and Title                                                                                                                                                                 |
| UC-02        | Create Booking | Allows B2C end user to book movie ticket by selectiing theatre,timing and preferred seats for the day and will make third party payment integration. This will also send SMS and Email notification to both B2B and B2C user after successful bookings |
| UC-03        | View Booking   | Allows B2C user to view the booking                                                                                                                                                                                                                    |
| UC-04        | Cancel Booking | Allows B2C user to cancel the booking and will initiate the refund payment after seat/s release. This will also send SMS/Email notification to both B2B and B2C users after successful cancelation/s                                                   |
| UC-05        | CRUD of Movie  | Allows B2B(Internal operator) to create, update, and delete Movie                                                                                                                                                                                      |

## 2.2 Summary of non-functional requirements
