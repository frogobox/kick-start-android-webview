package com.frogobox.webview.ui.util

/**
 * Created by faisalamircs on 01/09/2025
 * -----------------------------------------
 * Name     : Muhammad Faisal Amir
 * E-mail   : faisalamircs@gmail.com
 * Github   : github.com/amirisback
 * -----------------------------------------
 */


const val sampleHtmlText = """
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Github Profile of amirisback</title>
    <style>
        body {
            background: #f4f4f4;
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .profile-card {
            background: #fff;
            padding: 2rem 3rem;
            border-radius: 12px;
            box-shadow: 0 4px 24px rgba(0,0,0,0.08);
            text-align: center;
            max-width: 350px;
        }
        .profile-avatar {
            width: 100px;
            height: 100px;
            border-radius: 50%;
            object-fit: cover;
            margin-bottom: 1rem;
            border: 3px solid #24292e;
        }
        .profile-name {
            font-size: 1.5rem;
            font-weight: bold;
            color: #24292e;
            margin-bottom: 0.5rem;
        }
        .profile-link {
            display: inline-block;
            margin-top: 1rem;
            padding: 0.5rem 1.2rem;
            background: #24292e;
            color: #fff;
            border-radius: 6px;
            text-decoration: none;
            font-weight: 500;
            transition: background 0.2s;
        }
        .profile-link:hover {
            background: #444d56;
        }
    </style>
</head>
<body>
    <div class="profile-card">
        <img class="profile-avatar" src="https://avatars.githubusercontent.com/u/24654871?v=4" alt="amirisback Avatar">
        <div class="profile-name">Github Profile of amirisback</div>
        <a class="profile-link" href="https://github.com/amirisback" target="_blank">View Github</a>
    </div>
</body>
</html>
"""