![MineplexSK Banner](https://i.imgur.com/zO4o6Rb.png)

An unofficially supported Skript addon that allows you to use Skript within the Mineplex ecosystem, and interact with the special provided [Mineplex SDK](https://studio.mineplex.com/docs/sdk).

> [!IMPORTANT]  
> This isn't an official addon provided by Mineplex itself. This is a community developed and supported addon. We rely on contributions for this!

## Addon Documentation
[Expressions](/docs/expressions.md) ✦ [Conditions](/docs/conditions.md) ✦ [Effects](/docs/effects.md) ✦ [Events](/docs/events.md) ✦ [Functions](/docs/functions.md)


## Purpose
This exists to make it easier for people without Java knowledge to setup and use the Mineplex ecosystem, with the goal being to make it far easier for people to manage and create their projects quickly.
Our goal with this addon is to have this addon have full feature parity with the actual Mineplex Java SDK.

### Pre-requisites
- You must have [Skript plugin](https://github.com/SkriptLang/Skript/releases) downloaded already, this addon requires it!
- You must have a [Mineplex Studio project](https://studio.mineplex.com/docs/getting-started) created and ready to use

## How to install
- Add your **Skript** plugin into a directory within your Mineplex project named `external-plugins`
- Download the [latest version](https://github.com/BillyDotWS/MineplexSK/releases) of the addon from the Releases. 
- Add this addon jar into the same `external-plugins` directory

## How to use
This Skript addon allows you to use the Skript 'way of coding' with the Mineplex SDK. In order to do this, it adds some custom language to Skript to allow for usage.

### Using skript within Mineplex projects
*Note: requires you to have followed the Installation steps first*

In order to use Skript scripts within a project, drop your skript's into a folder (within your project). Within `external-plugins`, create a directory called `Skript`, within this directory, create another called `scripts`. 

Then create your Skript file (the same way as everywhere else): `scriptName.sk`

After that, use Skript the same way as normal, dropping extra scripts into the folder(s) and building your project!

## Contributing
> [!CAUTION]  
> This repository enforces a licence, meaning you cannot create a private version of this repository. Please contribute any improvements you make back to the base repository to assist in making it easier to use Skript on Mineplex for everyone! See [the license](/LICENSE) for more information.

We welcome contributions to improve this project! Please follow these guidelines to ensure a smooth contribution process:

### How to Contribute

1. **Fork the Repository**  
   Create a fork of this repository to your GitHub account.
2. **Clone Your Fork**  
   Clone your fork to your local machine:
   ```bash
   git clone https://github.com/your-username/repository-name.git
   ```
3. **Create a Branch**  
   Use a descriptive name for your branch:
   ```bash
   git checkout -b feature/your-feature-name
   ```
4. **Make Your Changes**   
   Make Your Changes
   Ensure your changes follow the coding standards and do not introduce any bugs.
5. **Run Tests**  
   Run all tests to confirm that your changes do not break existing functionality:
   ```bash
   mvn test
   ```
6. **Commit Your Changes**  
   Write clear and concise commit messages:
   ```bash
   git add .
   git commit -m "feature: description of your changes"
   ```
7. **Push Your Branch**  
   Push your branch to your forked repository:
   ```bash
   git push origin feature/your-feature-name
   ```
8. **Open a Pull Request**
   ```bash
   git push origin feature/your-feature-name
    ```
