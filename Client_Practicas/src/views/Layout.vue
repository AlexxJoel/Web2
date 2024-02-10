<template>
    <div>
      <b-row>
        <b-col>
          <div>
            <b-navbar type="dark" variant="dark">
              <b-navbar-nav>
                <b-nav-item href="#">Home</b-nav-item>
  
                <!-- Navbar dropdowns -->
                <b-nav-item-dropdown text="Lang" right>
                  <b-dropdown-item href="#">EN</b-dropdown-item>
                  <b-dropdown-item href="#">ES</b-dropdown-item>
                  <b-dropdown-item href="#">RU</b-dropdown-item>
                  <b-dropdown-item href="#">FA</b-dropdown-item>
                </b-nav-item-dropdown>
  
                <b-nav-item-dropdown text="User" right>
                  <b-dropdown-item href="#">Account</b-dropdown-item>
                  <b-dropdown-item href="#">Settings</b-dropdown-item>
                </b-nav-item-dropdown>
              </b-navbar-nav>
            </b-navbar>
          </div>
        </b-col>
      </b-row>
  
      <b-row>
        <b-col cols="12" md="3" xl="2">
          <div class="bg-dark text-white p-0 m-0" style="height: 95vh ;">
            <nav class="d-none d-md-block">
              <div class="p-3">
                <h4 id="sidebar-no-header-title">Navegación</h4>
                <nav class="mb-3">
                  <div>
                    <b-nav vertical class="w-25">
                      <b-nav-item >
                        <b-link :to="{ name: 'home' }" :active-class="'active'">Home</b-link>
                      </b-nav-item>
  
                      <b-nav-item>
                        <b-link :to="{ name: 'dashboard' }" :active-class="'active'">Dashboard</b-link>
                      </b-nav-item>
  
                      <b-nav-item>
                        <b-link :to="{ name: 'about' }" :active-class="'active'">about</b-link>
                      </b-nav-item>
  
                    </b-nav>
                  </div>
                </nav>
              </div>
            </nav>
          </div>
        </b-col>
  
        <b-col>
          <div class="mt-2">
            <router-view></router-view>
          </div>
        </b-col>
      </b-row>
    </div>
  </template>