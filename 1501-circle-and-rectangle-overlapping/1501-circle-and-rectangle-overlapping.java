class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {


    // Step 1: Check if the circle's center is inside the rectangle
    if (x1 <= xCenter && xCenter <= x2 && y1 <= yCenter && yCenter <= y2) {
        return true; // The circle and rectangle overlap
    }
        // Find the closest point on the rectangle to the circle's center
        int closestX = clamp(xCenter, x1, x2);
        int closestY = clamp(yCenter, y1, y2);

        // Calculate the distance from the circle's center to this closest point
        int distanceX = xCenter - closestX;
        int distanceY = yCenter - closestY;

        // Check if the distance is within the radius of the circle
        return (distanceX * distanceX + distanceY * distanceY) <= (radius * radius);
   
    }


    // Helper function to clamp a value between min and max
    private int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }
}