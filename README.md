# RayTracer
## Introduction
This is a program that can render an image of customizable spheres, triangles, and light sources in 3D space. You can define where the position of the camera is, where it is pointing, how far away the image is in 3D space, the position of as many spheres and triangles they want, their colors in RGB values, their reflectivity, the position of the lights, and even the light's colors.
## Bugs
- Currently bugs in the rendering of triangles and their reflections when the triangle isn't perpendicular to the camera.
## How to run
Run Main file
## Code
### Main
This class is where you define all of the paramteres required to render the image, including the camera position and direction, the image distance and size, the resolution of the final image, the positions and parameters of all of the spheres and triangles, and the smoothness of shadows.
### Vector
A class that stores 3D vectors as its x, y, and z coordinates. It contains functions to find the cross product, dot product, scalar product, and to get a unit Vector of the given vector.
### Point
A class that stores a point as its x, y and z coordinates. It contains functions to add and subtract Vectors and other Points. Also contains a function that jitters the value of the point by a inputed range.
### Color
A class that stores a color as an RGB value from 0 to 1. It contains functions to add it to other colors and single values.
### Camera
A class that stores the position of the camera(a Point), the direction it points(a Vector), and the up direction perpendicular to it(a Vector) to determine the rotation of the camera.
### Screen
A class that stores the size of the image in 3D space, and its distance from the camera. It also does computations to find the top corner of the screen that the Scene class uses to render the image.
### Buffer
A class that defines the resolution of the image, and also takes the final image and writes in a ppm file, that can be opened by GIMP, or any other program that can read the ppm file format.
### Light
This class is used to define a light source in space. You can define a position(a Point) and color(a Color).
### Shape
A base class that is used to define the triangle and sphere classes. It contains all the customizability of the color of the shape, and a colorCalc function, that calculates the color of a particular point on the shape, based on lightsources, and shadows of other shapes.
### Triangle
Note: Class is unfinished. There are bugs.
This class extends the Shape bas class and can be used to define triangles, using three points. It also contains a function to detect intersection of a ray with the triangle.
### Sphere
Similar to the Triangle class, this class extends the Shape bass class, and can be used to define a sphere using a center(a Point) and radius. Like the Triangle function, it also contains a function to detect intersection of a ray with the sphere. 
### IntersectionDetails
An object that is used when either the Triangle class of the Sphere class detects an intersection. It can store Point, the distance from the source of the vector used to calculate the intersection, and the the shape object itself, for later calculations.
### Scene
This class is where all of the logic of the code comes together. The scene loops through each pixel of the Buffer class, each time creating a vector from the camera to that point in 3D space, checking if it intersects with any of the defined shapes. If it does, then it calculates the color of the pixel, based on whether any light sources reach that point or of the light is blocked off by other shapes. After it determines the final color of the pixel, it gives all of the pixel values to the buffer class which convert it into a ppm file format.
